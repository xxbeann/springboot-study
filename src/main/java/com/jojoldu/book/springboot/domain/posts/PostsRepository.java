package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// MyBatis에서 DAO라고 부르는 DB layer 접근자.
// Jpa에서는 Repository라고 부르며 인터페이스로 생성.
// 단순히 인터페이스 생성 후, JpaRepository<Entity클래스, PK 타입>를 상속하면 기본 CRUD 메소드가 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
