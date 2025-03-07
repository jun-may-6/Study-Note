package com.ohgiraffers.comprehensive.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class testController {
    @GetMapping("")
    public String test() {
        return ("/board/test1");
    }
    @GetMapping("testMethod")
    public String tes2(Model model, @RequestParam Map<String ,String> map) {
        System.out.println(map);
        model.addAttribute("testMethod", "testMethod");
        return ("/board/test2");
    }
}
