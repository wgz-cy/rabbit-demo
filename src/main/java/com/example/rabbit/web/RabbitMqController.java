package com.example.rabbit.web;

import com.example.rabbit.config.RabbitConfig;
import com.example.rabbit.producer.ReservationProducer;
import com.example.rabbit.req.RecvRabbitMqRequest;
import com.example.rabbit.req.SendMqRequest;
import com.example.rabbit.req.SendRabbitMqRequest;
import com.example.rabbit.res.RecvRabbitMqResponse;
import com.example.rabbit.res.SendMqResponse;
import com.example.rabbit.res.SendRabbitMqResponse;
import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class RabbitMqController {

    @Autowired private ReservationProducer reservationMqService;

    @Autowired private RabbitConfig rabbitConfig;

    private static final String QUEUE_NAME = "myQueue-3";

    @PostMapping("/wgz/rabbit/sendMsg")
    public SendRabbitMqResponse send(@RequestBody SendRabbitMqRequest request) {
        SendRabbitMqResponse response = new SendRabbitMqResponse();
        String message = "Hello World!-持久化的哟";
        try {
            Connection connection = rabbitConfig.connectionFactory().createConnection();
            Channel channel = connection.createChannel(false);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 消息内容
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            channel.close();
            connection.close();
        } catch (Exception e) {
            response.setIsSuccess("失败");
            response.setRespCode("000");
            return response;
        }
        response.setIsSuccess("成功啦");
        response.setRespCode("111");
        return response;
    }

    @PostMapping("/wgz/rabbit/recvMsg")
    public RecvRabbitMqResponse recv(@RequestBody RecvRabbitMqRequest request) {
        RecvRabbitMqResponse response = new RecvRabbitMqResponse();
        // 获取到连接以及mq通道
        Connection connection = rabbitConfig.connectionFactory().createConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel(false);
        // 声明队列
        try {
            channel.basicQos(64);
            // 获取消息
            Consumer consumer =
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(
                                String consumerTag,
                                Envelope envelope,
                                AMQP.BasicProperties properties,
                                byte[] body)
                                throws IOException {
                            try {
                                response.setMsg(new String(body));
                                System.out.println("recv message: " + new String(body));
                                TimeUnit.SECONDS.sleep(1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            channel.basicAck(envelope.getDeliveryTag(), false);
                        }
                    };
            channel.basicConsume(QUEUE_NAME, consumer);
            // 等待回调函数执行完毕后，关闭资源
            TimeUnit.SECONDS.sleep(5);
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    // TODO 待调试
    @PostMapping("/wgz/rabbit/sendRabbit")
    public SendMqResponse send(@RequestBody SendMqRequest request) {
        SendMqResponse response = new SendMqResponse();
        String message = "Hello NI Ma";
        String messageId = UUID.randomUUID().toString();
        try {
            reservationMqService.sendMessage(
                    RabbitConfig.EXCHANGE_A, message, messageId, RabbitConfig.QUEUE_A);
        } catch (Exception e) {
            response.setIsSuccess("失败");
            response.setRespCode("000");
            return response;
        }
        response.setIsSuccess("成功啦");
        response.setRespCode("111");
        return response;
    }
}
