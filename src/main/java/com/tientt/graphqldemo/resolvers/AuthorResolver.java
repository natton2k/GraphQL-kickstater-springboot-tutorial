package com.tientt.graphqldemo.resolvers;

import com.tientt.graphqldemo.pojo.pojo.entities.Author;
import com.tientt.graphqldemo.pojo.pojo.entities.Book;
import com.tientt.graphqldemo.repositories.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorResolver implements GraphQLResolver<Author> {
    @Autowired
    BookRepository bookRepository;
    List<Book> books(Author author){
        return bookRepository.findAllByAuthor_Id(author.getId());
    }
}
