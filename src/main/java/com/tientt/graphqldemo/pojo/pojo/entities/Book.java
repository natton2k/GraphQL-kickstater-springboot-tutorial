package com.tientt.graphqldemo.pojo.pojo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    private String isbn;
    private String title;
    private Integer edition;
    private Integer publishedYear;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId", insertable = false, updatable = false)
    private Author author;
}
