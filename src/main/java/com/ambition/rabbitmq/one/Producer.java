package com.ambition.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Ambition
 * @date 2023/10/18 13:24
 * 消息生产者 发消息
 */
public class Producer {
    //    队列名称

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
        Channel channel = connectionFactory.newConnection().createChannel();
        /*
         *  queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * 参数：
         * 1.queue:队列名称
         * 2.durable：是否持久化，当mq重启之后，是否还在
         * 3.exclusive：是否独占，只能有一个消费者监听这个队列
         * 4.autoDelete：是否自动删除，当没有消费者时，自动删除掉
         * 5.arguments：参数
         */
        //        通道绑定对应消息队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        发布消息
        String message = "hello ambition";
        /*
         * basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
         * 参数：
         * 1.exchange：交换机名称，简单模式下交换机会使用默认的
         * 2.routingKey：路由名称
         * 3.props：配置信息
         * 4.body：发送消息数据
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("消息发送完毕");

    }
}
