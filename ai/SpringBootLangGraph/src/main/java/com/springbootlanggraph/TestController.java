package com.springbootlanggraph;

import com.springbootlanggraph.langGraph.IntroduceDTO;
import com.springbootlanggraph.langGraph.MakeDTOGraph;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static org.bsc.langgraph4j.utils.CollectionsUtils.mapOf;

@Controller
@RequiredArgsConstructor
public class TestController{

    private final OpenAiChatModel openAiChatModel;

    @GetMapping("/test")
    public String  test() throws Exception{
        MakeDTOGraph makeDTOGraph = new MakeDTOGraph("a", openAiChatModel,  new IntroduceDTO());
        var result = makeDTOGraph.buildStateGraph().compile().stream(mapOf());

        return "/";
    }
}
