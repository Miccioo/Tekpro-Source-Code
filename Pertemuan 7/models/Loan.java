package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private boolean returned;

    // Constructor
    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14); // 2-week loan period
        this.returned = false;
        book.setAvailable(false);
    }

    // Getters
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isReturned() { return returned; }

    // Calculate late fee
    public double calculateLateFee() {
        if (returned) return 0;
        
        LocalDate today = LocalDate.now();
        if (today.isAfter(dueDate)) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, today);
            return daysLate * 500.0; // 500 per day late fee
        }
        return 0;
    }

    // Return book method
    public void returnBook() {
        this.returned = true;
        book.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book.getTitle() +
                ", member=" + member.getName() +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                '}';
    }
}