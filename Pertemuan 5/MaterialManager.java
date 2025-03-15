import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MaterialManager {
    // 2. Kelas untuk mengelola bahan baku
    static final Set<String> RAW_MATERIALS = Set.of("Steel", "Plastic", "Aluminium");

    // ConcurrentHashMap untuk menyimpan stok material secara thread-safe
    private final ConcurrentHashMap<String, Integer> materialStock = new ConcurrentHashMap<>();
    private final Map<String, Integer> materialPrices = Map.of("Steel", 10, "Plastic", 5, "Aluminium", 15);

    public MaterialManager() {
        // Inisialisasi stok bahan baku dengan nilai awal 100 untuk setiap material
        for (String material : RAW_MATERIALS) {
            materialStock.put(material, 100);
        }
    }

    public void useMaterial(String material, int amount) {
        materialStock.computeIfPresent(material, (key, stock) -> stock >= amount ? stock - amount : stock);
    }

    public void displayMaterialStock() {
        System.out.println("\nStok Bahan Baku:");
        materialStock.forEach((material, stock) -> 
            System.out.println(material + ": " + stock + " unit (Harga: $" + materialPrices.get(material) + " per unit)"));
    }

    public boolean hasEnoughMaterial(String material, int amount) {
        return materialStock.getOrDefault(material, 0) >= amount;
    }

    public void buyMaterial(String material, int amount, int money) {
        int cost = materialPrices.get(material) * amount;
        if (money >= cost) {
            materialStock.put(material, materialStock.getOrDefault(material, 0) + amount);
            System.out.println("Berhasil membeli " + amount + " unit " + material + " seharga $" + cost);
        } else {
            System.out.println("Uang tidak cukup untuk membeli " + material);
        }
    }

    public int getMaterialPrice(String material) {
        return materialPrices.get(material);
    }
}

