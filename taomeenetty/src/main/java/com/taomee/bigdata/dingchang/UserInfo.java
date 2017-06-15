package com.taomee.bigdata.dingchang;

import java.io.Serializable;
import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Created by looper on 2017/5/26.
 */
public class UserInfo implements Serializable{
    private static final long serialVersionUID = -2454470291526740889L;

    /**
     *
     */
    public UserInfo() {
    }

    public UserInfo(String name, int age) {

        this.name = name;
        this.age = age;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] CodeC()
    {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.name.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.age);
        buffer.flip();
        value = null;
        byte[] result  = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

    public static void main(String[] args) {
        byte[] bytes = new UserInfo("netty",10).CodeC();
        System.out.println(bytes.length);
    }
}
