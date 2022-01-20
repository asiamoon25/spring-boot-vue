package com.study.springbootvue.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private String writer;
    private String inputText;
    private String writedate;
}
