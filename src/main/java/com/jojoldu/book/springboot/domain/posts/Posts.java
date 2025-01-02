// Posts 클래스는 실제 DB 테이블과 매칭될 클래스이며 보통 Entity 클래스라고 함.
package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 롬복 어노테이션
@Getter
// 기본 생성자 자동 추가
@NoArgsConstructor
// JPA 어노테이션 - 주요 어노테이션인 엔터티를 클래스에 가깝게 둠
// 테이블과 링크될 클래스. 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블과 매핑
// SalesManager.java -> sales_manager table
@Entity
public class Posts {
    // 해당 테이블의 PK필드
    @Id
    // PK 생성규칙 - GenerationType auto.increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블의 컬럼을 나타냄. 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됨.
    // 다만, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    // null 값 가능이 기본 옵션
    private String author;

    // 롬복의 빌더
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
