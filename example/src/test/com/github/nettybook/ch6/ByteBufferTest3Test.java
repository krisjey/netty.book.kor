package com.github.nettybook.ch6;

import java.nio.ByteBuffer;

import org.junit.Test;

public class ByteBufferTest3Test {
    @Test
    public void test() {
        ByteBuffer firstBuffer = ByteBuffer.allocate(11);
        System.out.println("초기 상태 : " + firstBuffer);

        for (int i = 0; i < 5; i++) {
            firstBuffer.put((byte) i);
            System.out.println(firstBuffer.get());
            System.out.println(firstBuffer);
        }
    }
}
