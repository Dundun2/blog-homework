package com.example.blog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter // 이 녀석덕분에 getId() 가능인건가?..
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Blog extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @javax.persistence.Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    //@GeneratedValue는 주키의 값을 위한 자동 생성 전략을 명시하는데 사용한다.
    // 선택적 속성으로 generator와 strategy가 있다. strategy는 persistence provider가 엔티티의 주키를
    // 생성할 때 사용해야 하는 주키생성 전략을 의미한다. 디폴트 값은 AUTO이다. generator는 SequenceGenerator나
    // TableGenerator 애노테이션에서 명시된 주키 생성자를 재사용할 때 쓰인다. 디폴트 값은 공백문자("")이다.

    @Id  //@Id는 해당 프로퍼티가 테이블의 주키(primary key) 역할을 한다는 것을 나타낸다

    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;


    public Blog(String title, String username, String password, String contents) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }
//requestDto를 사용하여 위에 Memo가 한번도 사용 안되게 되었다???


    public Blog(BlogRequestDto requestDto ) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();

    }

    public void update(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

}