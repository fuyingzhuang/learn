package com.ambition.rabbitmq.two;

import com.ambition.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author Ambition
 * @date 2023/10/18 16:14
 */
public class Worker01 {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
//        通过工具类获取连接对象
        Channel channel = RabbitMQUtils.getChannel();

//        消息的接收回调函数
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到消息：" + new String(message.getBody()));
        };

//        消息接收被取消是 执行如下的内容
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息接收被取消");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

    }
}
