// 패키지 선언: 이 클래스가 속한 패키지
package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 이 클래스가 Spring MVC 컨트롤러임을 나타냄 반환된 값이 view 로 매핑되지 않고 클라이언트에 직접 반환
@RestController
public class HelloController {
    // HTTP 요청 처리 메서드 - GET 요청 처리 메서드
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
