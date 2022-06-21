package com.codewithamit.blog.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentsDto {

    private int id;
    private String content;
}
