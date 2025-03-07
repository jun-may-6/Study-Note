package com.example.gptApi;

import com.example.structure.Test;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatbotController {
    @Autowired
    OpenAiChatModel model;
    @RequestMapping("/")
    public String chat() {
        return "chat.html";
    }
    @RequestMapping("/input")
    public String input() {
        return "input_article.html";
    }

    @RequestMapping("/test")
    public String  test(){
        Test test = new Test();
        test.listOutputConverter(model);
        test.customConverter(model);
        return "chat.html";
    }
}
