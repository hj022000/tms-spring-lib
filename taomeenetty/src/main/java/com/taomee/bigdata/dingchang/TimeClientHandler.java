package com.taomee.bigdata.dingchang;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by looper on 2017/5/24.
 */
public class TimeClientHandler extends ChannelHandlerAdapter{

    private int counter;
   // private byte[] req ;
   // private ByteBuf firstMessage = null;
    static final String ECHO_REQ = "Hi,taomee,welcome to netty.$_";

    public TimeClientHandler() {

       // req = ("QURRY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    //当服务器端返回应答消息时，channelRead方法会被调用，此时处理服务器端返回来的结果
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("the counter is "+ ++counter + ",the recv server msg:" +msg);
    }

    //当客户端的服务器建立通信链路了，netty Nio线程会调用channelActive方法，然后调用ChannelHandlerContext类的
    //writeAndFlush方法将数据从客户端发送到服务端。
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i = 0 ;i < 100 ; i++)
        {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       // super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
