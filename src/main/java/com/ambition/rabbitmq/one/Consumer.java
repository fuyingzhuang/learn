package com.ambition.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Ambition
 * @date 2023/10/18 13:40
 * 消息消费者 接收消息
 */
public class Consumer {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
//        创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
//        设置连接rabbitmq主机
        connectionFactory.setHost("101.201.67.203");
//        设置端口号
        connectionFactory.setPort(5672);
//        设置用户名
        connectionFactory.setUsername("guest");
//        设置密码
        connectionFactory.setPassword("guest");
//        获取连接对象
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
//        通道绑定对应消息队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        消费消息
        /*
         * basicConsume(String queue, boolean autoAck, Consumer callback)
         * 参数：
         * 1.queue：队列名称
         * 2.autoAck：是否自动确认 true：自动确认 false：手动确认
         * 3.callback：回调函数 消费者未成功消费消息的回调函数
         * 4.callback：回调函数 消费者接收到消息后回调此函数
         */
        channel.basicConsume(QUEUE_NAME, true, (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
        }, consumerTag -> {
            System.out.println("消息消费被中断");
        });


    }
}
