public class Menu {
    private final String nama;
    private final double harga;
    private int stok;

    public Menu(byte id, String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter
    public String getNama() {
        return this.nama;
    }

    public double getHarga() {
        return this.harga;
    }

    public int getStok() {
        return this.stok;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah > 0 && stok >= jumlah) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi atau jumlah tidak valid.");
        }
    }

    public boolean isOutOfStock() {
        return stok == 0;
    }

    
}
