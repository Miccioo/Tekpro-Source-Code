public class Welcome {
    public static void main(String[] args) {
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for(int i = 0; i < greeting.length(); i++);
            System.out.print("=");
        System.out.println();

        Welcome Soal = new Welcome();
        Soal.soal1();
        Soal.soal2();
    }

    public void soal1(){
        byte angka1 = 125;
        byte angka2 = 6;
        byte Hasil = (byte) (angka1+angka2);
        System.out.println("Hasil 1 : "+Hasil);
    }

    public void soal2(){
        int i = 42;
        String s = (i<40)? "life" : (i>50)? "universe" : "everything";
        System.out.println(s);
    }
}
