package com.github.nettybook.ch6;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;

import org.junit.Test;

public class WriteByteBufferTest {
    @Test
    public void writeTest() {
        ByteBuffer firstBuffer = ByteBuffer.allocateDirect(11);
        assertEquals(0, firstBuffer.position());
        assertEquals(11, firstBuffer.limit());
        assertEquals(11, firstBuffer.capacity());

        firstBuffer.put((byte) 1);
        firstBuffer.put((byte) 2);
        firstBuffer.put((byte) 3);
        firstBuffer.put((byte) 4);
        assertEquals(4, firstBuffer.position());
        assertEquals(11, firstBuffer.limit());

        firstBuffer.flip();
        assertEquals(0, firstBuffer.position());
        assertEquals(4, firstBuffer.limit());
    }
}
