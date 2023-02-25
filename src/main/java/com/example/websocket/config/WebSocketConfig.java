package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//Annotation @EnableWebSocketMessageBroker được dùng để bật tính năng WebSocket server.
// Chúng ta thực hiện implement interface WebSocketMessageBrokerConfigurer
// và cung cấp việc triển khai thực hiện một số phương thức của nó để cấu hình kết nối websocket.
// link: https://viblo.asia/p/tao-ung-dung-chat-don-gian-voi-spring-boot-va-websocket-naQZR1DjKvx
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    Trong phương thức đầu tiên, chúng ta đăng ký một websocket endpoint mà các máy khách sẽ sử dụng để
//    kết nối với máy chủ websocket của chúng ta.
//    SockJS được sử dụng để bật tùy chọn dự phòng cho các trình duyệt không hỗ trợ websocket.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/chatroom","/user");
        registry.setUserDestinationPrefix("/user");
    }
}
