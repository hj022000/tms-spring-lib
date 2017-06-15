package com.taomee.bigdata.spring;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by looper on 2017/5/24.
 */
public class TimeServerHandler extends ChannelHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        ByteBuf buf = (ByteBuf) msg;
        byte [] req  = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("服务器收到的请求:" + body);
        String currentTime = "QURRY TIME ORDER".equals(body) ? new Date(System.currentTimeMillis()).toString():"BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //super.channelReadComplete(ctx);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
