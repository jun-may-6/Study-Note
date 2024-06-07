package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("test")
    public String test(Model model, @RequestParam String value) {
        DTO dto = new DTO();
        dto.setValue(value);
        model.addAttribute("dtoType", dto);
        return "/result";
    }
    @GetMapping("test2")
    public String test2(Model model, @RequestParam String value) {
        DTO dto = (DTO) model.getAttribute("dtoType");
        dto.setValue2(value);
        model.addAttribute("dto", dto);
        return "/result2";
    }
}
