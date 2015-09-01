package com.github.nettybook.ch6;

import static org.junit.Assert.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

import org.junit.Test;

public class PooledByteBufferTest {
    @Test
    public void createPooledHeapBufferTest() {
        ByteBuf buf = PooledByteBufAllocator.DEFAULT.heapBuffer(11);

        assertEquals(false, PooledByteBufAllocator.DEFAULT.isDirectBufferPooled());
    }

    @Test
    public void createPooledDirectBufferTest() {
        ByteBuf buf = PooledByteBufAllocator.DEFAULT.directBuffer(11);

        assertEquals(true, PooledByteBufAllocator.DEFAULT.isDirectBufferPooled());
    }
}
