package com.study.test.study01test;

public class HelloWorldController {

    @RequestMapping(value="/helloSpring.sp", method=RequestMethod.POST)
    public String helloSpingPost(HelloSpring spring,Model model){
        /*
         * 파라미터로 들어온 spring객체에 폼에서 전송된 데이터가 담겨있다.
         */
        String id = spring.getId();
        model.addAttribute("message", id);
        return "/WEB-INF/view/helloSpring.jsp";

    }

    @RequestMapping(value="/helloSpring.sp", method=RequestMethod.GET)
    public String helloSpingGet(@RequestParam String id,Model model){
        model.addAttribute("message", id);
        return "/WEB-INF/view/helloSpring.jsp";
    }

    @RequestMapping(value="/helloSpringList.sp", method=RequestMethod.POST)
    public String helloSpringList(HelloSpringList list,Model model){
        model.addAttribute("list", list.getList());
        return "helloSpringList";

    }
}
