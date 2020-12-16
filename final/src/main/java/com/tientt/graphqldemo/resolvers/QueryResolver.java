package com.tientt.graphqldemo.resolvers;

import com.tientt.graphqldemo.pojo.pojo.entities.Author;
import com.tientt.graphqldemo.pojo.pojo.entities.Book;
import com.tientt.graphqldemo.repositories.AuthorRepository;
import com.tientt.graphqldemo.repositories.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    Author getAuthor(Long authorID){
        return authorRepository.findById(authorID).get();
    }

    List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    List<Book> getBooksByAuthor(Long authorID){
        return bookRepository.findAllByAuthor_Id(authorID);
    }
    Book getBookByIsbn(String isbn){
        return bookRepository.findById(isbn).get();
    }
}
