package com.github.nettybook.ch7.junit;

import static org.junit.Assert.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;

import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StripDecoderTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        String writeData = "test";
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new StripDecoder());

        ByteBuf request = Unpooled.wrappedBuffer(writeData.getBytes());
        embeddedChannel.writeInbound(request);
        
        ByteBuf response = (ByteBuf) embeddedChannel.readOutbound();

        assertEquals("a" + writeData + "a", response.toString(Charset.defaultCharset()));

        embeddedChannel.finish();
    }

}
