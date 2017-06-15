package com.taomee.bigdata.dingchang;

//import io.netty.channel.EventLoopGroup;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

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
            //netty服务端解决解包和粘包的问题。
            //解包、粘包的问题。
            // LineBasedFrameDecoder判断一行按照"\n"或者"\r\n"为结束符，之前的一行为一个数据包，StringDecoder包就是将接受到的对象转换成String，
            // 然后调用后面的handler
           // ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
            //设置定长的Decoder
            socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(20));
           // socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
            socketChannel.pipeline().addLast(new StringDecoder());
            //需要添加handler
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }
    public static void main(String[] args) {

        new TimeServer().bind(8005);
    }
}
