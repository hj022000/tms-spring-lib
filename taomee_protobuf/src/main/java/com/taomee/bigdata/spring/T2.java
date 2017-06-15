package com.taomee.bigdata.spring;

import com.google.protobuf.InvalidProtocolBufferException;
import com.taomee.bigdata.proto.PersonEntity;

/**
 * Created by looper on 2017/6/2.
 */
public class T2 {

    public static void main(String[] args) {

        PersonEntity.Person.Builder builder = PersonEntity.Person.newBuilder();
        builder.setId(10);
        builder.setName("nili");
        builder.setEmail("331025680@qq.com");
        PersonEntity.Person person = builder.build();
        byte[] buf = person.toByteArray();

        try {
            PersonEntity.Person rec = PersonEntity.Person.parseFrom(buf);
            System.out.println("rec id: " + rec.getId());
            System.out.println("rec name: " + rec.getName());
            System.out.println("rec email: " + rec.getEmail());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
