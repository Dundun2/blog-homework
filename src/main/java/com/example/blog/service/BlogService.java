package com.example.blog.service;

import com.example.blog.domain.Blog;
import com.example.blog.domain.BlogRepository;
import com.example.blog.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;


@RequiredArgsConstructor //final로 명명된 놈을 반드시 챙긴다? MemoRepository 보완용
@Service //이건 서비스라구 명명
public class BlogService {

    private final BlogRepository blogRepository;

    // 이게 일종의 인스턴스 변수인가 ?.. final은 이 항목이 꼭필요함을 나타낸다??


    @Transactional // 업데이트 할떄 DB에 반영되어야해 !!
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto);
        return blog.getId();
    }

    public boolean passwordcheck(Long id, String password) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return Objects.equals(password,blog.getPassword());
    }
}