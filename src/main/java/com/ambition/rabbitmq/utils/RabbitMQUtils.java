package com.ambition.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Ambition
 * @date 2023/10/18 15:51
 * RabbitMQ工具类
 */
public class RabbitMQUtils {
    //    得到一个连接的channel
    public static Channel getChannel() throws Exception {
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
        Channel channel = connectionFactory.newConnection().createChannel();
        return channel;
    }
}
