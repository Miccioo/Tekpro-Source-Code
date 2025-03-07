import java.util.ArrayList;
import java.util.Scanner;

public class Pesan {
    private final ArrayList<Film> daftarFilm;
    private final Tiket tiket;
    private Pelanggan pelanggan;

    public Pesan(int stokTiket, float hargaTiket) {
        daftarFilm = new ArrayList<>();
        tiket = new Tiket(stokTiket, hargaTiket);
    }

    public void tambahFilm(String judul, int minAge, float rating) {
        daftarFilm.add(new Film(judul, minAge, rating));
    }

    public void tampilkanFilm() {
        System.out.println("\nDaftar Film:");
        for (Film film : daftarFilm) {
            System.out.println(film.getJudul() + " | Umur: " + film.getMinAge() + "+ | Rating: " + film.getRating());
        }
    }

    public void inputDataPelanggan() {
        Scanner scn = new Scanner(System.in);
        System.out.print("\nMasukkan Nama Anda: ");
        String nama = scn.nextLine();
        System.out.print("Masukkan Umur Anda: ");
        int umur = scn.nextInt();
        scn.nextLine();
        pelanggan = new Pelanggan(nama, umur);
    }

    public void pesanTiket() {
        if (pelanggan == null) {
            System.out.println("Harap masukkan data pelanggan terlebih dahulu!");
            return;
        }

        Scanner scn = new Scanner(System.in);
        System.out.print("\nMasukkan nama film yang ingin dipesan: ");
        String namaFilm = scn.nextLine();

        Film filmPilihan = null;
        for (Film film : daftarFilm) {
            if (film.getJudul().equalsIgnoreCase(namaFilm)) {
                filmPilihan = film;
                break;
            }
        }

        if (filmPilihan == null) {
            System.out.println("Film tidak ditemukan.");
            return;
        }

        if (pelanggan.getUmur() < filmPilihan.getMinAge()) {
            System.out.println("Maaf, Anda belum cukup umur untuk menonton film ini.");
            return;
        }

        System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlah = scn.nextInt();

        if (tiket.kurangiStok(jumlah)) {
            float totalHarga = jumlah * tiket.getHarga();
            Pemesanan pemesanan = new Pemesanan(pelanggan, filmPilihan, jumlah, totalHarga);
            pemesanan.tampilkanDetailPemesanan();
        }
    }
}
