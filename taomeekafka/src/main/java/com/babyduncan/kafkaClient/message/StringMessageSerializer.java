package com.babyduncan.kafkaClient.message;

/**
 * Created by looper on 2017/6/6.
 */
import kafka.message.Message;
import kafka.serializer.Decoder;
import kafka.serializer.Encoder;
import kafka.serializer.StringDecoder;
import kafka.serializer.StringEncoder;

public class StringMessageSerializer implements Decoder<String>, Encoder<String> {
    @Override
    public String fromBytes(byte[] bytes) {
        return null;
    }

    @Override
    public byte[] toBytes(String s) {
        return new byte[0];
    }

   /* private static final Encoder<String> encoder = new StringEncoder();
    private static final Decoder<String> decoder = new StringDecoder();


    public String toEvent(Message message) {
        return decoder.toEvent(message);
    }


    public Message toMessage(String event) {
        return encoder.toMessage(event);
    }*/
}