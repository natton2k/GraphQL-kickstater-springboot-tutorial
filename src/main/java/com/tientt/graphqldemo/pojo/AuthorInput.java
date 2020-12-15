package com.tientt.graphqldemo.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorInput {
    private Long id;
    private String fullname;
}
