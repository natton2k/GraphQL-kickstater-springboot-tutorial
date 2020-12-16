package com.tientt.graphqldemo.resolvers;

import com.tientt.graphqldemo.pojo.AuthorInput;
import com.tientt.graphqldemo.pojo.pojo.entities.Author;
import com.tientt.graphqldemo.repositories.AuthorRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    AuthorRepository authorRepository;
    Author updateAuthor(AuthorInput input){
        Author author = new Author();
        author.setId(input.getId());
        author.setFullname(input.getFullname());
        return authorRepository.saveAndFlush(author);
    }

    boolean deleteAuthor(Long authorID){
        authorRepository.deleteById(authorID);
        return true;
    }
}
