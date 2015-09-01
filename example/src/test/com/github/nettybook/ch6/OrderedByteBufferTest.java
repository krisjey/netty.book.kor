package com.github.nettybook.ch6;

import static org.junit.Assert.assertEquals;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

import java.nio.ByteOrder;

import org.junit.Test;

public class OrderedByteBufferTest {
    @Test
    public void pooledHeapBufferTest() {
        ByteBuf buf = Unpooled.buffer(11);
        assertEquals(ByteOrder.BIG_ENDIAN, buf.order());

        buf.markReaderIndex();
        buf.writeShort(1);
        assertEquals(1, buf.readShort());

        buf.resetReaderIndex();

        ByteBuf lettleEndianBuf = buf.order(ByteOrder.LITTLE_ENDIAN);
        assertEquals(256, lettleEndianBuf.readShort());
    }
}
