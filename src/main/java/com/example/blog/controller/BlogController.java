package com.example.blog.controller;

import com.example.blog.domain.Blog;
import com.example.blog.domain.BlogRepository;
import com.example.blog.domain.BlogRequestDto;
import com.example.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // new 어쩌고 신경쓸 필요없다.
@RestController // 이 2줄이면 new 어쩌고 저쩌고 필요없어짐

//근본적인 차이점은 @Controller의 역할은 Model 객체를 만들어 데이터를 담고 View를 찾는 것이지만,
// @RestController는 단순히 객체만을 반환하고 객체 데이터는 JSON 또는 XML 형식으로 HTTP 응답에 담아서 전송합니다.
// 물론 @Controller와 @ResponseBody를 사용하여 만들 수 있지만 이러한 방식은 RESTful
// 웹서비스의 기본 동작이기 때문에 Spring은 @Controller와 @ResponseBody의 동작을 조합한 @RestController을 도입했습니다.

public class BlogController {
    // 필수적이라 final
    private final BlogRepository blogRepository; // create,read,delete
    private final BlogService blogService;  //for update

    @PostMapping("/api/blogs") //RequestBody -> 요청사항이 올때 body에 들어있는 친구를 MemoRequestDto에 넣어달라?
    public Blog createMemo(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blogs") // 정보 조회
    public List<Blog> getBlogs() {
        return blogRepository.findAllByOrderByCreatedAtDesc();
    }

    @PutMapping("/api/blogs/{id}") //정보 변경
    public Long updateBlogs(@PathVariable Long id,@RequestParam String password, @RequestBody BlogRequestDto requestDto) {
        if(blogService.passwordcheck(id,password))
        blogService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/blogs/{id}")    //@pathvariable은 경로에 있는 id변수를 받기위해서 이다.
    public Long deleteBlogs(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }

}