package com.tientt.graphqldemo.repositories;

import com.tientt.graphqldemo.pojo.pojo.entities.Author;
import com.tientt.graphqldemo.pojo.pojo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findAllByAuthor_Id(Long authorID);
}
