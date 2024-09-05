package com.example.gptApi;

import org.springframework.ai.chat.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChatbotWebSocketHandler extends TextWebSocketHandler {

    String systemMessage = "사용자 질문에 답변하는 Chatbot Assistant입니다. 상황에 따라서 필요한 함수를 적절하게 호출합니다.";

    @Autowired
    OpenAIChatbotComponent chatbotComponent;

    /**
     * 핸드셰이크 이후 클라이언트에서 텍스트 데이터를 보냈을 때 호출
     * @param session: 클라이언트와의 연결을 관리하는 세션 객체
     * @param message: 클라이언트에서 전송된 텍스트
     * @throws Exception: 예외처리
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        /* 받은 텍스트 추출 및 출력 */
        String payload = message.getPayload();
        log.info("Received message: " + payload);

        /* 챗봇 컴포넌트 활용해서 답변 생성 */
        Message msg = chatbotComponent.getChatResponse(systemMessage, payload);

        /* 생성된 답변 추출하여 반환 */
        session.sendMessage(new TextMessage(msg.getContent()));
    }

    /**
     * 핸드셰이크가 성공한 직후 호출되는 함수
     * @param session: 클라이언트와의 연결을 관리하는 세션 객체
     * @throws Exception: 예외처리
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        /* 서버와 클라이언트가 통신하기 위한 세션의 ID 출력 */
        log.info("Connection established with session: " + session.getId());
    }
}
