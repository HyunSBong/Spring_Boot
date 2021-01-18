package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControlller {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring 입니다.");
        return "hello"; // resources:templates/의 hello.html으로
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // ResponseBody 문자반환
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // ResponseBody 객체반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

/*
 @ResponseBody 를 사용
    HTTP의 BODY에 문자 내용을 직접 반환
    viewResolver 대신에 HttpMessageConverter가 동작
    기본 문자처리: StringHttpMessageConverter
    기본 객체처리: MappingJackson2HttpMessageConverter
    byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
 */
