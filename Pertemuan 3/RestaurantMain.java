import java.util.Scanner;

public class RestaurantMain {

    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        menu.tambahMenuMakanan("Bala-Bala", 1000, 20);
        menu.tambahMenuMakanan("Gehu", 1000, 20);
        menu.tambahMenuMakanan("Tahu", 1000, 20);
        menu.tambahMenuMakanan("Molen", 1000, 20);

        System.out.println("Menu sebelum pemesanan:");
        menu.tampilMenuMakanan();

        try ( // Pemesanan
                Scanner scn = new Scanner(System.in)) {
            System.out.print("\nJumlah Pesanan: ");
            int jml_pesanan = scn.nextInt();
            scn.nextLine(); // Tambahkan nextLine() untuk membuang newline setelah nextInt()
            String[] list_nama = new String[jml_pesanan];
            int[] list_jml = new int[jml_pesanan];
            for (int i = 0; i < jml_pesanan; i++) {
                System.out.print("\nNama Makanan: ");
                list_nama[i] = scn.nextLine(); // Perbaiki input
                
                System.out.print("Jumlah Makanan: ");
                list_jml[i] = scn.nextInt();
                scn.nextLine(); // Buang newline agar tidak error
            }   for (int i = 0; i < jml_pesanan; i++) {
                menu.pesanMakanan(list_nama[i], list_jml[i]);
            }   System.out.println("\nMenu setelah pemesanan:");
            menu.tampilMenuMakanan();
            // Tutup scanner untuk mencegah memory leak
        }
    }
}
