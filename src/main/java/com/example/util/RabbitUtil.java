package com.example.util;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitUtil {

    @Value("${spring.rabbitmq.host}")
    public static String host;

    @Value("${spring.rabbitmq.port}")
    public static int port;

    @Value("${spring.rabbitmq.username}")
    public static String username;

    @Value("${spring.rabbitmq.password}")
    public static String password;

    public static Connection getConnection() throws Exception {
        //定义连接工厂
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        // 通过工程获取连接
        Connection connection = connectionFactory.createConnection();
        return connection;
    }
}
