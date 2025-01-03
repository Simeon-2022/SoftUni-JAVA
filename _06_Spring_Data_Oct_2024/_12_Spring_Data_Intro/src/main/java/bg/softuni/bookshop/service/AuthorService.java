package bg.softuni.bookshop.service;

import bg.softuni.bookshop.data.entities.Author;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    boolean areAuthorsImported();

    Author getRandomAuthor();

    void printAllAuthorsWithOneBookBefore1990();

    void printAllAuthorsWithDecsCount();

    Author getAuthorByFirstAndLastName();
}
