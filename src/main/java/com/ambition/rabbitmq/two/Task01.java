package com.ambition.rabbitmq.two;

import com.ambition.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;

/**
 * @author Ambition
 * @date 2023/10/18 16:27
 */
public class Task01 {
    public static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    }
}

//
