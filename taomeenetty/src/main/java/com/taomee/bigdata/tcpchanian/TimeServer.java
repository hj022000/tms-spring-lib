package com.taomee.bigdata.tcpchanian;

//import io.netty.channel.EventLoopGroup;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by looper on 2017/5/24.
 * 使用 netty框架 实现服务器端通信开发
 */
public class TimeServer {


    public void bind(int port)
    {
            EventLoopGroup bossGroup = new NioEventLoopGroup();//设置处理连接请求组
            EventLoopGroup workGroup = new NioEventLoopGroup();//设置处理网络读写请求组
            try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG,1024).childHandler(new ChildChannelHandler());
            //绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();
            //等待服务端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>
    {
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            //需要添加handler
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }
    public static void main(String[] args) {

        new TimeServer().bind(8005);
    }
}
