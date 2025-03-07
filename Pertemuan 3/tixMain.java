public class tixMain {
    public static void main(String[] args) {
        Pesan pesan = new Pesan(10, 50000); // 10 tiket tersedia, harga Rp 50.000

        // Tambah film
        pesan.tambahFilm("Interstellar", 13, 8.6f);
        pesan.tambahFilm("Spiderman", 17, 9.0f);
        pesan.tambahFilm("Deadpool", 17, 8.0f);
        pesan.tambahFilm("Frozen", 3, 8.0f);

        // Tampilkan daftar film
        pesan.tampilkanFilm();

        // Input data pelanggan
        pesan.inputDataPelanggan();

        // Pesan tiket
        pesan.pesanTiket();
    }
}
