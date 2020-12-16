package com.tientt.graphqldemo.repositories;

import com.tientt.graphqldemo.pojo.pojo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
