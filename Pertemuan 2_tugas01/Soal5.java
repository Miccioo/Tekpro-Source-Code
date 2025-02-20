public class Soal5 {
    public static void main(String[] args){
        String a = "Kampus";
        String b = "Jakarta";


        System.out.println("Kata Pertama : " + a);
        System.out.println("Kata Kedua : " + b);

        // Menggunakan .length() untuk mengukur jumlah suatu string
        int Sum_Length = a.length() + b. length();
        System.out.println(Sum_Length);

        // Membandingkan apakah a lebih besar secara lexicographically dibanding b?
        // Untuk kasus ini kita gunakan .compareToIgnoreCase() untuk membandingkan tanpa pengaruh case
        // Jika membandingkan apakah karakter B datang sebelum karakter A dengan .compareTo() < 0
        if(a.compareToIgnoreCase(b) < 0){
            System.out.println("NO");
        }
        // Jika A dan B Sama
        else if(a.compareToIgnoreCase(b) == 0){
            System.out.println("A is equal to b");
        }
        // Jika A lebih duluan dari B
        else {
            System.out.println("YES");
        }

        // Kita Pisahkan terlebih dahulu untuk karakter pertama dari string a dan b lalu menggunakan 
        // method .substring(0, 1). method ini berfungsi untuk membaca karakter yang dimulai dari 0 hingga 1 karakter terbaca
        // lalu kita Uppercase menggunakan .toUpperCase(), dan menambahkan sisa string dengan beginIndex 1
        a = a.substring(0, 1).toUpperCase() + a.substring(1);
        b = b.substring(0, 1).toUpperCase() + b.substring(1);

        System.out.println(a);
        System.out.println(b);
    }
}
