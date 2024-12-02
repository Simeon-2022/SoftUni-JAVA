package bg.softuni.bookshop.data.repositories;

import bg.softuni.bookshop.data.entities.Author;
import bg.softuni.bookshop.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Set<Book> findBookByReleaseDateIsAfter(LocalDate date);

    Set<Book> findAllByAuthorIsOrderByReleaseDateDescTitleAsc(Author author);

    Set<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String fName, String lName);
}
