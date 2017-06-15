package com.taomee.bigdata.tcpnetty;

import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

/**
 * Created by looper on 2017/5/25.
 */
public class App3 {

    public static void main(String[] args) {
        String abc = "abc";
        String abcd = "abc" + System.getProperty("line.separator").toString();
        System.out.println(abc);
        String abcd_ = abcd.substring(0,abcd.length()-System.getProperty("line.separator").length());
        System.out.println(abc.equalsIgnoreCase(abcd_));
        ChannelPipeline channelPipeline ;
        DelimiterBasedFrameDecoder delimiterBasedFrameDecoder ;
    }
}
