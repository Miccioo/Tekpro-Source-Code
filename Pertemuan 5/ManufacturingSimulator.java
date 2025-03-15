import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManufacturingSimulator {
private static final Scanner scanner = new Scanner(System.in);
    private static final MaterialManager materialManager = new MaterialManager();
    private static final OrderQueue orderQueue = new OrderQueue();
    private static final List<Machine> machines = new CopyOnWriteArrayList<>();
    private static int money = 100; // Uang awal pemain
    private static int day = 1;

    public static void main(String[] args) {
        System.out.println("Selamat datang di Manufacturing Simulator Game!");
        initializeGame();

        while (true) {
            System.out.println("\n=== Hari " + day + " ===");
            generateRandomOrders();
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> displayStatus();
                case 2 -> processOrders();
                case 3 -> manageMachines();
                case 4 -> buyMaterials();
                case 5 -> nextDay();
                case 6 -> {
                    System.out.println("Terima kasih telah bermain!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void initializeGame() {
        // Inisialisasi mesin produksi
        machines.add(new Machine("M001", "Slow", 100, 1, 50));
        machines.add(new Machine("M002", "Medium", 100, 2, 100));
        machines.add(new Machine("M003", "Fast", 100, 3, 150));
    }

    private static void generateRandomOrders() {
        Random random = new Random();
        int numOrders = random.nextInt(3) + 1; // 1-3 pesanan per hari
        for (int i = 0; i < numOrders; i++) {
            String id = "O" + (100 + random.nextInt(900)); // ID acak
            String product = List.of("Car Door", "Engine Block", "Wheel", "Chassis").get(random.nextInt(4));
            int quantity = random.nextInt(10) + 1; // Jumlah acak 1-10
            boolean isPriority = random.nextBoolean(); // Prioritas acak
            int reward = quantity * (random.nextInt(10) + 5); // Reward acak

            Order order = new Order(id, product, quantity, "Pending", reward);
            if (isPriority) {
                orderQueue.addPriorityOrder(order);
            } else {
                orderQueue.addOrder(order);
            }
            System.out.println("Pesanan baru diterima: " + order);
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tampilkan Status");
        System.out.println("2. Proses Pesanan");
        System.out.println("3. Kelola Mesin");
        System.out.println("4. Beli Bahan Baku");
        System.out.println("5. Lanjut ke Hari Berikutnya");
        System.out.println("6. Keluar");
        System.out.print("Pilih opsi: ");
    }

    private static void displayStatus() {
        System.out.println("\nUang Anda: $" + money);
        materialManager.displayMaterialStock();
        System.out.println("\nDaftar Mesin:");
        machines.forEach(System.out::println);
        orderQueue.displayProcessedOrders();
    }

    private static void processOrders() {
        if (!orderQueue.hasOrders()) {
            System.out.println("Tidak ada pesanan yang perlu diproses.");
            return;
        }

        Optional<Order> orderOptional = orderQueue.processNextOrder();
        orderOptional.ifPresent(order -> {
            for (Machine machine : machines) {
                if (machine.getDurability() > 0 && materialManager.hasEnoughMaterial("Steel", order.quantity())) {
                    System.out.println("Memproses pesanan: " + order + " menggunakan " + machine.getId());
                    materialManager.useMaterial("Steel", order.quantity());
                    money += order.reward();
                    machine.use();
                    System.out.println("Pesanan selesai! Anda mendapatkan $" + order.reward());
                    return;
                }
            }
            System.out.println("Tidak ada mesin yang tersedia atau bahan baku tidak cukup. Pesanan " + order.id() + " ditunda.");
        });
    }

    private static void manageMachines() {
        System.out.println("\nKelola Mesin:");
        System.out.println("1. Perbaiki Mesin");
        System.out.println("2. Beli Mesin Baru");
        System.out.println("3. Jual Mesin");
        System.out.print("Pilih opsi: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> repairMachine();
            case 2 -> buyMachine();
            case 3 -> sellMachine();
            default -> System.out.println("Pilihan tidak valid.");
        }
    }

    private static void repairMachine() {
        System.out.print("Masukkan ID Mesin yang akan diperbaiki: ");
        String machineId = scanner.nextLine();
        for (Machine machine : machines) {
            if (machine.getId().equals(machineId)) {
                machine.repair();
                System.out.println("Mesin " + machineId + " telah diperbaiki!");
                return;
            }
        }
        System.out.println("Mesin tidak ditemukan.");
    }

    private static void buyMachine() {
        System.out.println("\nDaftar Mesin yang Tersedia:");
        System.out.println("1. Mesin Slow (Kecepatan: 1, Harga: $50)");
        System.out.println("2. Mesin Medium (Kecepatan: 2, Harga: $100)");
        System.out.println("3. Mesin Fast (Kecepatan: 3, Harga: $150)");
        System.out.print("Pilih mesin yang ingin dibeli: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String id = "M" + (machines.size() + 100);
        Machine machine = switch (choice) {
            case 1 -> new Machine(id, "Slow", 100, 1, 50);
            case 2 -> new Machine(id, "Medium", 100, 2, 100);
            case 3 -> new Machine(id, "Fast", 100, 3, 150);
            default -> null;
        };

        if (machine != null && money >= machine.getCost()) {
            machines.add(machine);
            money -= machine.getCost();
            System.out.println("Berhasil membeli " + machine.getType() + " mesin!");
        } else {
            System.out.println("Uang tidak cukup atau pilihan tidak valid.");
        }
    }

    private static void sellMachine() {
        System.out.print("Masukkan ID Mesin yang ingin dijual: ");
        String machineId = scanner.nextLine();
        for (Machine machine : machines) {
            if (machine.getId().equals(machineId)) {
                machines.remove(machine);
                money += machine.getCost() / 2; // Jual mesin dengan harga setengah
                System.out.println("Mesin " + machineId + " telah dijual seharga $" + (machine.getCost() / 2));
                return;
            }
        }
        System.out.println("Mesin tidak ditemukan.");
    }

    private static void buyMaterials() {
        System.out.print("Masukkan nama bahan baku (Steel/Plastic/Aluminium): ");
        String material = scanner.nextLine();
        System.out.print("Masukkan jumlah yang ingin dibeli: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        materialManager.buyMaterial(material, amount, money);
    }

    private static void nextDay() {
        System.out.println("\nMemajukan ke hari berikutnya...");
        day++;
    }
}
