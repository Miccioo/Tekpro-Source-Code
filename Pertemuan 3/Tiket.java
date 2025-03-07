public class Tiket {
    private int stok;
    private final float harga;

    public Tiket(int stok, float harga) {
        this.stok = stok;
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public float getHarga() {
        return harga;
    }

    public boolean kurangiStok(int jumlah) {
        if (jumlah > 0 && stok >= jumlah) {
            stok -= jumlah;
            return true;
        } else {
            System.out.println("Stok tiket tidak mencukupi atau jumlah tidak valid.");
            return false;
        }
    }
}
