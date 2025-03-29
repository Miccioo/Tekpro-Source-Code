package repositories;

import models.Loan;
import models.Book;
import models.Member;
import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    void addLoan(Loan loan);
    void returnLoan(Loan loan);
    List<Loan> getLoansByMember(Member member);
    List<Loan> getActiveLoansByMember(Member member);
    Optional<Loan> findActiveLoan(Book book);
}