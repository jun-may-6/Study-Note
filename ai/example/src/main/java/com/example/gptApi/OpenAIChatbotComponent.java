package com.example.gptApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.function.FunctionCallbackContext;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OpenAIChatbotComponent {


    private final OpenAiChatModel chatModel;

    @Autowired
    FunctionCallbackContext functionCallbackContext;

    public OpenAIChatbotComponent(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * 프롬프트, 유저의 메세지를 받아서 답변을 생성하는 함수
     * @param systemMessage: 미리 작성해둔 프롬프트
     * @param userMessage: 사용자가 입력한 메세지
     * @return : LLM 결과
     */
    public Message getChatResponse(String systemMessage, String userMessage) {
        Message msgSys = new SystemMessage(systemMessage);
        Message msgUser = new UserMessage(userMessage);

        List<Message> list = new ArrayList<>();

        list.add(msgUser);
        list.add(msgSys);

        Prompt prompt = new Prompt(list, OpenAiChatOptions.builder().withFunction("testFunction").build());

        Message result =  chatModel.call(prompt).getResult().getOutput();
        return result;
    }
}