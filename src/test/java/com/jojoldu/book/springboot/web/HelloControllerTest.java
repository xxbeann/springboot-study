package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Junit4에서 테스트 실행기를 지정. SpringRunner를 사용하여 Spring Context를 로드하고, 필요한 빈을 주입하며 테스트를 실행
// 스프링 부트 테스트와 Junit 사이에 연결자 역할을 수행
@RunWith(SpringRunner.class)

// SpringBoot의 테스트 어노테이션, 컨트롤러 레이어만 테스트할 때 실행.
// HelloController와 관련된 필요한 빈(MockMVC)만 로드.
// 서비스 레이어나 데이터 레이어는 로드하지 않음.
@WebMvcTest(controllers = HelloController.class)

// 클래스 선언
public class HelloControllerTest {

    // Spring이 MockMvc객체(Bean)를 자동으로 주입
    // MockMvc 컨트롤러의 요청과 응답을 테스트 할 수 있는 가짜 MVC 환경을 제공
    @Autowired
    // MockMvc 객체를 통해 HTTP 요청을 가상으로 보내고, 응답을 검증하는 데 사용
    private MockMvc mvc;

    // 테스트 메서드
    // 이 메서드가 테스트 메서드임을 나타내는 어노테이션 - Junit에 의해 실행
    @Test
    // /hello요청을 보내면 "hello"라는 문자열이 반환되는지 검증
    public void gethello_request_helloreturn() throws Exception {
        String hello = "hello";

        /// hello 경로로 http get 요청을 보냄.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}