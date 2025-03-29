package repositories;

import models.Book;
import models.Member;
import models.Loan;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryLoanRepository implements LoanRepository {
    private List<Loan> loans = new ArrayList<>();

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public void returnLoan(Loan loan) {
        loan.returnBook();
    }

    @Override
    public List<Loan> getLoansByMember(Member member) {
        return loans.stream()
                .filter(loan -> loan.getMember().equals(member))
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> getActiveLoansByMember(Member member) {
        return loans.stream()
                .filter(loan -> loan.getMember().equals(member) && !loan.isReturned())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Loan> findActiveLoan(Book book) {
        return loans.stream()
                .filter(loan -> loan.getBook().equals(book) && !loan.isReturned())
                .findFirst();
    }
}