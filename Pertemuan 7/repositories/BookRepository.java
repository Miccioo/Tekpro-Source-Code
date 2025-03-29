package repositories;

import models.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void addBook(Book book);
    void removeBook(Book book);
    Optional<Book> findBookById(int id);
    List<Book> getAllBooks();
    List<Book> getAvailableBooks();
}