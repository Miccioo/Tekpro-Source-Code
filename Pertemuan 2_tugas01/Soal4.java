public class Soal4 {

    // Fungsi untuk mengubah tipe data menjadi int lalu return dengan tipe data short
    static short methodOne(long l) {
        int i = (int) l;
        return (short)i;
    }
    public static void main(String[] args) {
        // Assign nilai d
        double d = 10.25;

        // Passing nilai dari 2 tipe data variabel yang berbeda, dengan menggunakan float, nilai dari d akan berubah menjadi float
        float f = (float) d;

        // Nilai dari variabel b akan di assign dengan perubahan nilai yang sesuai dengan tipe data short -> byte
        byte b = (byte) methodOne((long) f);
        System.out.println(b);
    }
}
