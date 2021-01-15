package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControlller {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring 입니다.");
        return "hello"; // resources:templates/의 hello.html으로
    }
}
