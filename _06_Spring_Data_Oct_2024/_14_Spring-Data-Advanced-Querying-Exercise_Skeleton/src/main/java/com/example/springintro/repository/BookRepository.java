package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.model.entity.EditionType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestrictionIs(AgeRestriction ageRestriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal upperPrice);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findByReleaseDateBefore(LocalDate before);

    List<Book> findByTitleContainingIgnoreCase(String string);

    List<Book> findByAuthorLastNameStartingWith(String string);

    @Query("SELECT COUNT(b.id) FROM Book AS b WHERE length(b.title) > :length")
    int countBooksByTitleIsLongerThan(int length);

    BookInfo findByTitle(String title);

    @Query("""
            update Book as b set b.copies = b.copies + :copiesToAdd where b.releaseDate > :dateAfter
            """)
    @Modifying
    @Transactional
    int updateAllBooksByCopies(LocalDate dateAfter, int copiesToAdd);

    @Modifying
    @Transactional
    int deleteBookByCopiesLessThan(int copies);
}
