package com.taomee.bigdata.tcpnetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by looper on 2017/5/24.
 */
public class TimeClientHandler extends ChannelHandlerAdapter{

    private int counter;
    private byte[] req ;
   // private ByteBuf firstMessage = null;

    public TimeClientHandler() {

        req = ("QURRY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    //当服务器端返回应答消息时，channelRead方法会被调用，此时处理服务器端返回来的结果
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
       /* ByteBuf buf = (ByteBuf) msg;
        byte [] req  = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");*/
        String body = (String)msg;
        System.out.println("now is " + body + ",the counter is "+ ++counter);
    }

    //当客户端的服务器建立通信链路了，netty Nio线程会调用channelActive方法，然后调用ChannelHandlerContext类的
    //writeAndFlush方法将数据从客户端发送到服务端。
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ByteBuf buf = null;
        for(int i = 0 ;i < 100 ; i++)
        {
         //   buf = Unpooled.copiedBuffer(req.length);
            buf = Unpooled.buffer(req.length);
            System.out.println("i = "+i);
            buf.writeBytes(req);
            ctx.writeAndFlush(buf);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       // super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
