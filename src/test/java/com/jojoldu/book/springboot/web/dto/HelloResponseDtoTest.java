// assertj 를 사용하여 Lombok 기능(접근자와 생성자)이 제대로 동작하는지 테스트
package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트 클래스 선언
public class HelloResponseDtoTest {

    // 테스트 메서드
    @Test
    public void lombok_function_test() {

        //given(테스트 준비 단계)
        String name = "test";
        int amount = 1000;

        //when(테스트 실행 단계) dto 객체 생성
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then(테스트 검증 단계)
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
