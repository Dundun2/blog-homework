package com.example.blog.domain;

import lombok.Getter;

@Getter // private일때 가져오기위해??
// getter 은 인스턴스 변수를 반환하고 setter 은 인스턴스 변수를 대입하거나 수정한다.

//Dto는 필요한 것을 물고다니는 녀석

public class BlogRequestDto {
    private String title;
    private String username;
    private String password;
    private String contents;
}