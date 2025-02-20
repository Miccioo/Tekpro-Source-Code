public class Soal3 {
    public static void main(String[] args) {
        // Assign nilai x
        double x = 92.98;

        // Mengubah nilai yang awalnya bertipe data long menjadi integer lalu di assign ke variabel nx 
        int nx = (int) Math.round(x);
        System.out.println("Hasil pembulatan: " + nx);
    }
}
