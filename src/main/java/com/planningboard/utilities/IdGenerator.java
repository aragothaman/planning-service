package com.planningboard.utilities;


import java.nio.ByteBuffer;
import java.util.UUID;

public class IdGenerator {
    final static IdGenerator instance = new IdGenerator();


    public IdGenerator() {

    }

    public String getId() {
        return UUID.randomUUID().toString();
    }

    public String getShortId() {
        long l = ByteBuffer.wrap(getId().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

    public static IdGenerator getInstance() {
        return IdGenerator.instance;
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator.getInstance().getShortId());
    }
}
