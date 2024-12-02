package com.example.springintro.service;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorCopies;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<Author> getAllAuthorsStartingWith(String start);

    List<String> getAllAuthorsSortedByBookCopies();

    List<AuthorCopies> findAllAuthorsAndTheirBookCopySum();

    int findNumberOfBooksWrittenBy(String firstName, String lastName);
}
