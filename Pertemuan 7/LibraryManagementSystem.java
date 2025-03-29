import models.Book;
import models.Member;
import models.Loan;
import repositories.LoanRepository;
import repositories.MemberRepository;
import repositories.BookRepository;
import repositories.InMemoryBookRepository;
import repositories.InMemoryMemberRepository;
import repositories.InMemoryLoanRepository;

import java.util.Scanner;

public class LibraryManagementSystem {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private LoanRepository loanRepository;
    private Scanner scanner;

    public LibraryManagementSystem() {
        this.bookRepository = new InMemoryBookRepository();
        this.memberRepository = new InMemoryMemberRepository();
        this.loanRepository = new InMemoryLoanRepository();
        this.scanner = new Scanner(System.in);
        initializeDefaultData();
    }

    private void initializeDefaultData() {
        // Add some default books
        bookRepository.addBook(new Book(1, "Java Programming", "John Smith"));
        bookRepository.addBook(new Book(2, "Python Basics", "Jane Doe"));
        bookRepository.addBook(new Book(3, "Data Structures", "Alice Johnson"));

        // Add some default members
        memberRepository.addMember(new Member(1, "Alice", "alice@email.com"));
        memberRepository.addMember(new Member(2, "Bob", "bob@email.com"));
    }

    public void run() {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: displayAllBooks(); break;
                case 2: addNewBook(); break;
                case 3: borrowBook(); break;
                case 4: returnBook(); break;
                case 5: displayActiveBorrowedBooks(); break;
                case 6: 
                    System.out.println("Terima kasih. Sampai jumpa!");
                    return;
                default: 
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n--- SISTEM MANAJEMEN PERPUSTAKAAN ---");
        System.out.println("1. Lihat Semua Buku");
        System.out.println("2. Tambah Buku Baru");
        System.out.println("3. Pinjam Buku");
        System.out.println("4. Kembalikan Buku");
        System.out.println("5. Lihat Buku yang Dipinjam");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu: ");
    }

    private void displayAllBooks() {
        System.out.println("\n--- DAFTAR BUKU ---");
        bookRepository.getAllBooks().forEach(System.out::println);
    }

    private void addNewBook() {
        System.out.print("Masukkan ID Buku: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Masukkan Judul Buku: ");
        String title = scanner.nextLine();

        System.out.print("Masukkan Nama Penulis: ");
        String author = scanner.nextLine();

        Book newBook = new Book(id, title, author);
        bookRepository.addBook(newBook);
        System.out.println("Buku berhasil ditambahkan!");
    }

    private void borrowBook() {
        // Book selection
        System.out.print("Masukkan ID Buku: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        var bookOptional = bookRepository.findBookById(bookId);
        if (bookOptional.isEmpty() || !bookOptional.get().isAvailable()) {
            System.out.println("Buku tidak tersedia.");
            return;
        }

        // Member selection
        System.out.print("Masukkan ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        var memberOptional = memberRepository.findMemberById(memberId);
        if (memberOptional.isEmpty()) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        // Create loan
        Loan loan = new Loan(bookOptional.get(), memberOptional.get());
        loanRepository.addLoan(loan);
        
        System.out.println("Buku berhasil dipinjam!");
        System.out.println("Batas pengembalian: " + loan.getDueDate());
    }

    private void returnBook() {
        // Member selection
        System.out.print("Masukkan ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        var memberOptional = memberRepository.findMemberById(memberId);
        if (memberOptional.isEmpty()) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        // Display active loans
        var activeLoans = loanRepository.getActiveLoansByMember(memberOptional.get());
        if (activeLoans.isEmpty()) {
            System.out.println("Tidak ada buku yang sedang dipinjam.");
            return;
        }

        System.out.println("Buku yang sedang dipinjam:");
        for (int i = 0; i < activeLoans.size(); i++) {
            System.out.println((i + 1) + ". " + activeLoans.get(i).getBook().getTitle());
        }

        System.out.print("Pilih buku yang akan dikembalikan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice < 1 || choice > activeLoans.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Loan loanToReturn = activeLoans.get(choice - 1);
        double lateFee = loanToReturn.calculateLateFee();
        
        if (lateFee > 0) {
            System.out.printf("Denda keterlambatan: Rp %.2f%n", lateFee);
        }

        loanRepository.returnLoan(loanToReturn);
        System.out.println("Buku berhasil dikembalikan.");
    }

    private void displayActiveBorrowedBooks() {
        System.out.print("Masukkan ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        var memberOptional = memberRepository.findMemberById(memberId);
        if (memberOptional.isEmpty()) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        var activeLoans = loanRepository.getActiveLoansByMember(memberOptional.get());
        if (activeLoans.isEmpty()) {
            System.out.println("Tidak ada buku yang sedang dipinjam.");
            return;
        }

        System.out.println("Buku yang sedang dipinjam:");
        activeLoans.forEach(loan -> {
            System.out.println(
                "Judul: " + loan.getBook().getTitle() + 
                ", Tanggal Pinjam: " + loan.getBorrowDate() + 
                ", Batas Pengembalian: " + loan.getDueDate()
            );
        });
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.run();
    }
}