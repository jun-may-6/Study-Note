package com.example.structure;

import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.List;
import java.util.Map;

public class Test {
    public void listOutputConverter(OpenAiChatModel chatClient) {
        ListOutputConverter listConverter = new ListOutputConverter(new DefaultConversionService());

        String format = listConverter.getFormat();
        String template = """
        Provide a list of 3 {subject}
        {format}
        """;
        PromptTemplate promptTemplate = new PromptTemplate(template, Map.of("subject", "fruits", "format", format));
        Prompt prompt = new Prompt(promptTemplate.createMessage());
        Generation generation = chatClient.call(prompt).getResult();

        List<String> fruits = listConverter.convert(generation.getOutput().getContent());

        System.out.println(fruits);
    }
    public void customConverter(OpenAiChatModel chatClient){
        CustomConverter customConverter = new CustomConverter();

        String format = customConverter.getFormat();
        String template = """
        Provide detailed information about the product in {format}
        """;

        PromptTemplate promptTemplate = new PromptTemplate(template, Map.of("format", format));
        Prompt prompt = new Prompt(promptTemplate.createMessage());
        Generation generation = chatClient.call(prompt).getResult();

        CustomDTO productInfo = customConverter.convert(generation.getOutput().getContent());

        System.out.println(productInfo);
    }

}
