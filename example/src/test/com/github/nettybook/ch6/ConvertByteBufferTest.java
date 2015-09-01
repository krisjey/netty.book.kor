package com.github.nettybook.ch6;

import static org.junit.Assert.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.junit.Test;

public class ConvertByteBufferTest {
    final String source = "Hello world";
    
    @Test
    public void convertNettyBufferToJavaBuffer() {
        ByteBuf buf = Unpooled.buffer(11);
        
        buf.writeBytes(source.getBytes());
        assertEquals(source, buf.toString(Charset.defaultCharset()));

        ByteBuffer nioByteBuffer = buf.nioBuffer();
        assertNotNull(nioByteBuffer);
        assertEquals(source, new String(nioByteBuffer.array()));
    }

    @Test
    public void convertJavaBufferToNettyBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(source.getBytes());
        ByteBuf nettyBuffer = Unpooled.wrappedBuffer(byteBuffer);

        assertEquals(source, nettyBuffer.toString(Charset.defaultCharset()));
    }
}
