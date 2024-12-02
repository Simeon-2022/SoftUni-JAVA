package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY  SIZE(a.books) DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findByFirstNameEndsWith(String start);


    @Query("""
            select concat(a.firstName,' ',a.lastName) as fullName, sum(b.copies) as copiesSum 
            from Book as b
            join b.author as a
            group by fullName
            order by copiesSum desc 
            """)
    List<AuthorCopies> findAuthorsAndBookCopySum();

    @Procedure(procedureName = "count_author_books", outputParameterName = "result")
    int findCountOfBooksByAuthor(String firstName, String lastName);
}
