package com.tientt.graphqldemo.resolvers;

import com.tientt.graphqldemo.pojo.pojo.entities.Author;
import com.tientt.graphqldemo.pojo.pojo.entities.Book;
import graphql.kickstart.tools.GraphQLResolver;

public class BookResolver implements GraphQLResolver<Book> {
    Author author(Book book){
        return book.getAuthor();
    }
}
