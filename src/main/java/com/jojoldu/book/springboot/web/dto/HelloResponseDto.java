// 데이터 전달을 위한 객체. 필드 값을 외부에서 읽을 수 있도록 접근자(get) 생성, 생성자 생성
package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
// 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor
// 선언된 모든 final 필드가 포함된 생성자를 생성해줌
// final 이 없는 필드는 생성자에 포함되지 않는다.
public class HelloResponseDto {
    // private: 외부에서 직접 접근하지 못하도록 캡슐화
    // final: 필드 값이 한 번 설정되면 변하지 않도록 보장
    private final String name;
    private final int amount;
}
