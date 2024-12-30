// 패키지 선언: 이 클래스가 속한 패키지
package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 이 클래스가 Spring MVC 컨트롤러임을 나타냄 반환된 값이 view 로 매핑되지 않고 클라이언트에 직접 반환
@RestController
public class HelloController {
    // HTTP 요청 처리 메서드 - GET 요청 처리 메서드
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    // 클라이언트로부터 name과 amount값을 요청 파라미터로 받아 DTO 객체 생성 후 JSON 포맷으로 변환
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") Integer amount){
        // RequestParam 어노테이션 - 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        // name 과 amount는 API를 호출하는 곳에서 넘겨준 값들.
        return new HelloResponseDto(name, amount);
    }
}
