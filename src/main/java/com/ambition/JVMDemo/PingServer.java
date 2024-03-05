package com.ambition.JVMDemo;

import java.io.*;
import java.net.*;
import java.util.*;

/*
 * 用于处理UDP上的ping请求的服务器。
 * 服务器处于无限循环中，监听传入的UDP数据包。
 * 当收到数据包时，服务器简单地将封装的数据发送回客户端。
 */

public class PingServer
{
   private static final double LOSS_RATE = 0.3; // 丢包率
   private static final int AVERAGE_DELAY = 100; // 毫秒为单位的平均延迟时间

   public static void main(String[] args) throws Exception
   {
      // 获取命令行参数。
      if (args.length != 1) {
         System.out.println("需要参数: 端口");
         return;
      }
      int port = Integer.parseInt(args[0]);

      // 创建随机数生成器，用于模拟数据包丢失和网络延迟。
      Random random = new Random();

      // 创建一个DatagramSocket实例，用于接收和发送UDP数据包，通过命令行指定的端口。
      DatagramSocket socket = new DatagramSocket(port);

      // 处理循环。
      while (true) {
         // 创建一个DatagramPacket来保存传入的UDP数据包。
         DatagramPacket request = new DatagramPacket(new byte[1024], 1024);

         // 阻塞，直到主机接收到一个UDP数据包。
         socket.receive(request);

         // 打印接收到的数据。
         printData(request);

         // 决定是否回复，或者模拟数据包丢失。
         if (random.nextDouble() < LOSS_RATE) {
            System.out.println("   未发送回复。");
            continue;
         }

         // 模拟网络延迟。
         Thread.sleep((int) (random.nextDouble() * 2 * AVERAGE_DELAY));

         // 发送回复。
         InetAddress clientHost = request.getAddress();
         int clientPort = request.getPort();
         byte[] buf = request.getData();
         DatagramPacket reply = new DatagramPacket(buf, buf.length, clientHost, clientPort);
         socket.send(reply);

         System.out.println("   回复已发送。");
      }
   }

   /*
    * 将ping数据打印到标准输出流。
    */
   private static void printData(DatagramPacket request) throws Exception
   {
      // 获取数据包的字节数组。
      byte[] buf = request.getData();

      // 将字节包装在ByteArrayInputStream中，以便将数据读取为字节流。
      ByteArrayInputStream bais = new ByteArrayInputStream(buf);

      // 将字节数组输出流包装在输入流读取器中，以便将数据读取为字符流。
      InputStreamReader isr = new InputStreamReader(bais);

      // 将输入流读取器包装在缓冲读取器中，以便逐行读取字符数据。
      // （一行是由\r和\n的任意组合终止的字符序列。）
      BufferedReader br = new BufferedReader(isr);

      // 消息数据包含在一行中，因此读取这一行。
      String line = br.readLine();

      // 打印主机地址和接收到的数据。
      System.out.println(
              "来自 " +
                      request.getAddress().getHostAddress() +
                      " 的接收数据: " +
                      new String(line) );
   }
}
