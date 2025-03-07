package com.springbootlanggraph.langGraph;

import lombok.RequiredArgsConstructor;
import org.bsc.langgraph4j.StateGraph;
import org.bsc.langgraph4j.state.AgentState;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.bsc.langgraph4j.StateGraph.END;
import static org.bsc.langgraph4j.StateGraph.START;
import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;
import static org.bsc.langgraph4j.utils.CollectionsUtils.mapOf;

public class MakeDTOGraph {
    @Value("${spring.ai.openai.api-key}")
    private String openApiKey;
    private final String question;
    private final OpenAiChatModel chatClient;
    private final IntroduceDTO introduceDTO;

    public MakeDTOGraph(String question, OpenAiChatModel chatClient, IntroduceDTO introduceDTO) {
        this.question = question;
        this.chatClient = chatClient;
        this.introduceDTO = introduceDTO;
    }

    public static class State extends AgentState {
        public State(Map<String, Object> initData) {
            super(initData);
        }
        public String question() {
            Optional<String> result = value("question");
            return result.orElseThrow( () -> new IllegalStateException( "question is not set!" ) );
        }
        public IntroduceDTO introduce(){
            Optional<IntroduceDTO> result = value("introduce");
            return result.orElseThrow( () -> new IllegalStateException( "introduce is not set!" ) );
        }
    }

    private Map<String, Object> setIntroduce(State state){
        System.out.println(2);
        return mapOf("question", question);
    }
    private Map<String, Object> makeIntroduceDTO(State state){
        System.out.println(3);
        List<Message> list = new ArrayList<>();
        BeanOutputConverter<IntroduceDTO> beanOutputConverter = new BeanOutputConverter<>(IntroduceDTO.class);
        String format = beanOutputConverter.getFormat();
        String systemMessage = "당신은 입력받은 정보를 토대로 자기소개 객체를 만드는 어시스턴트입니다. 모르는 필드는 Null로 작성하세요.";
        Message sysMsg =  new SystemMessage(systemMessage);
        list.add(sysMsg);
        sysMsg = new SystemMessage(format);
        list.add(sysMsg);
        list.add(new UserMessage("난 99년생 편승준이야."));

        System.out.println("test1");
        Generation generation = chatClient.call(new Prompt(list)).getResult();
        System.out.println("test2");

        IntroduceDTO result = beanOutputConverter.convert(generation.getOutput().getContent());
        System.out.println("test");
        System.out.println(result);
        return mapOf("introduce", result);
    }

    private String  returnTrue(State state){
        return "true";
    }

    public StateGraph<State> buildStateGraph() throws Exception{
        System.out.println(1);
        return new StateGraph<>(State::new)
                .addNode("setIntroduce", node_async(this::setIntroduce))
                .addNode("makeIntroduceDTO", node_async(this::makeIntroduceDTO))
                .addEdge(START, "setIntroduce")
                .addEdge("setIntroduce", "makeIntroduceDTO")
                .addEdge("makeIntroduceDTO", END);
    }
}
