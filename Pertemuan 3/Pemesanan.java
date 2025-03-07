public class Pemesanan {
    private final Pelanggan pelanggan;
    private final Film film;
    private final int jumlahTiket;
    private final float totalHarga;

    public Pemesanan(Pelanggan pelanggan, Film film, int jumlahTiket, float totalHarga) {
        this.pelanggan = pelanggan;
        this.film = film;
        this.jumlahTiket = jumlahTiket;
        this.totalHarga = totalHarga;
    }

    public void tampilkanDetailPemesanan() {
        System.out.println("\nDetail Pemesanan:");
        System.out.println("Nama Pelanggan: " + pelanggan.getNama());
        System.out.println("Film: " + film.getJudul());
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Total Harga: Rp. " + totalHarga);
    }
}
