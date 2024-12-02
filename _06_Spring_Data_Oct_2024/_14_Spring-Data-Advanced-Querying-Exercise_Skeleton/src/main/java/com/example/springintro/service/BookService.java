package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findTitlesByAgeRestriction(String ageRestriction);

    List<String> findByGoldEditionTypeAndLessThan5000Copies();

    List<String> findByPrice();

    List<String> findBooksNoInReleaseDateRange(int year);

    List<String> findBooksBeforeReleaseDate(String date);

    List<String> findByTitleContainingAString(String string);

    List<String> findByAuthorWithLastNameStarting(String string);

    int countBookWithTitleLongerThan(int length);

    BookInfo findBookWithSelectedFields(String title);

    int addCopiesToBooksWithReleaseDateAfter(LocalDate dateAfter, int copiesToAdd);

    int deleteBooksWithCopiesLessThan(int copies);
}
