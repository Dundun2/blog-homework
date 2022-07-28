package com.example.blog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// 어디다 가져다 쓸것인가? Memo란 클래스고 (@id를 언급하는 것이겠지?..)아이디가 Long 인 녀석에 대해..
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByCreatedAtDesc();

    //
}