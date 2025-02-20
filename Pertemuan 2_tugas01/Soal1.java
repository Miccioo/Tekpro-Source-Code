import java.util.Scanner;

public class Soal1 {

    public static void main(String[] args) {

        // Fungsi untuk menginput test angka
        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("Number of Test Case : ");
            
            long number_test = scn.nextLong();
            
            // Mengecek apakah number_test masuk kedalam kategori tipe data byte
            if(number_test <= Byte.MAX_VALUE && number_test >= Byte.MIN_VALUE){
                System.out.println(number_test + " Can be fitted in:");
                System.out.println("* byte");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            }

            // Mengecek apakah number_test masuk kedalam kategori tipe data Short
            else if(number_test <= Short.MAX_VALUE && number_test >= Short.MIN_VALUE){
                System.out.println(number_test + " Can be fitted in:");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            }

            // Mengecek apakah number_test masuk kedalam kategori tipe data Integer
            else if(number_test <= Integer.MAX_VALUE && number_test >= Integer.MIN_VALUE){
                System.out.println(number_test + " Can be fitted in:");
                System.out.println("* long");
            }

            // Mengecek apakah number_test masuk kedalam kategori tipe data Long
            else if(number_test <= Long.MAX_VALUE && number_test >= Long.MIN_VALUE){
                System.out.println(number_test + " Can be fitted in:");
                System.out.println("* long");
            }
            // Tidak masuk kedalam tipe data selain yang diatas
            else {
                System.out.println(number_test + " Can't be fitted in anywhere");
            }
        }
    }
}