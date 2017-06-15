package com.taomee.bigdata.fengefu_dingchang;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by looper on 2017/5/24.
 */
public class TimeServerHandler extends ChannelHandlerAdapter{

    private int counter ;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        //System.out.println("程序进入:");
       // ByteBuf buf = (ByteBuf) msg;
        /*byte [] req  = new byte[buf.readableBytes()];
        buf.readBytes(req);*/
       // String body = new String(req,"UTF-8").substring(0,req.length - System.getProperty("line.separator").length());
        String body = (String)msg;
        System.out.println("服务器收到的请求:" + body + ";the counter is " + ++counter);

        body += "$_";
        ByteBuf resp = Unpooled.copiedBuffer(body.getBytes());
       // ctx.write(resp);
       ctx.writeAndFlush(resp);
        //System.out.println("1111");
    }

   /* @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //super.channelReadComplete(ctx);
        ctx.flush();
    }*/

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
