import java.util.ArrayList;

public class Restaurant {
    private final ArrayList<Menu> daftarMenu;
    private static byte id = 0; // Pastikan id diinisialisasi ke 0

    public Restaurant() {
        daftarMenu = new ArrayList<>();
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        daftarMenu.add(new Menu(id, nama, harga, stok));
        nextId(); // Tambahkan id setelah menambah menu
    }

    public void tampilMenuMakanan() {
        for (Menu item : daftarMenu) {
            if (!item.isOutOfStock()) {
                System.out.println(item.getNama() + " [" + item.getStok() + "] \tRp. " + item.getHarga());
            }
        }
    }

    public void pesanMakanan(String nama, int jumlah) {
        for (Menu item : daftarMenu) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                if (item.getStok() >= jumlah) {
                    item.kurangiStok(jumlah);
                    System.out.println("Pesanan " + nama + " sebanyak " + jumlah + " berhasil!");
                } else {
                    System.out.println("Stok " + nama + " tidak mencukupi!");
                }
                return;
            }
        }
        System.out.println("Menu tidak ditemukan!");
    }

    public static void nextId() {
        id++;
    }
}
