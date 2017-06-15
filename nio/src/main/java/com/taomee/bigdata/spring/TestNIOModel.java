package com.taomee.bigdata.spring;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by looper on 2017/5/23.
 */
public class TestNIOModel {

    public static void main(String[] args) {

        try {
            //1、设置 ServerSocketChannel
            ServerSocketChannel acceptorSvr = ServerSocketChannel.open();

            //2、绑定端口，并且设置为非阻塞模式.
            acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"),8086));
            acceptorSvr.configureBlocking(false);

            //3、创建reactor线程，并且创建多路复用模型
            Selector selector = Selector.open();
            //new Thread(new Reac)

            // 4、
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
