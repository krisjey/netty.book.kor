package com.github.nettybook.ch6;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;

import org.junit.Test;

public class RightByteBufferTest3 {
    @Test
    public void test() {
        ByteBuffer firstBuffer = ByteBuffer.allocate(11);
        System.out.println("초기 상태 : " + firstBuffer);

        firstBuffer.put((byte) 1);
        firstBuffer.put((byte) 2);
        assertEquals(2, firstBuffer.position());
        
        firstBuffer.rewind(); 
        assertEquals(0, firstBuffer.position()); 
        
        assertEquals(1, firstBuffer.get());
        assertEquals(1, firstBuffer.position());
        
        System.out.println(firstBuffer);

    }
}
