package com.github.nettybook.ch7.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.netty.channel.embedded.EmbeddedChannel;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.junit.Test;

public class TelnetServerHandlerTest {
    @Test
    public void testConnect() throws UnknownHostException {
        String firstResponse = "Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n";

        EmbeddedChannel channel = new EmbeddedChannel(new TelnetServerHandlerNetty());
        String response = (String) channel.readOutbound();

        assertNotNull(response);
        assertEquals(firstResponse, (String) response); // 기대한 첫 번째 응답.

        response = (String) channel.readOutbound();
        assertNotNull(response);
        assertEquals("It is " + new Date() + " now.\r\n", response);

        channel.writeInbound("test");
        channel.writeInbound("\r\n");

        String inbound = (String) channel.readOutbound();
        assertEquals("Did you say 'test'?\r\n", inbound);

        // assertTrue(channel.writeInbound(Unpooled.wrappedBuffer("test".getBytes(Charset.forName("UTF-8")))));
        // // 채널 상대측에서 메시지 전송.
        // assertTrue(channel.writeInbound(Unpooled.wrappedBuffer("\r\n".getBytes(Charset.forName("UTF-8")))));
        // // 채널 상대측에서 메시지 전송.

        // ByteBuf inboundBuf = (ByteBuf) channel.readInbound(); //
        // TelnetServerHandlerNetty의 인바운드 데이터.
        // assertEquals("test\r\n",
        // inboundBuf.toString(Charset.forName("UTF-8")));

        String outboundBuf = (String) channel.readOutbound();
        assertNotNull(outboundBuf); // null
        // assertEquals(response, (String) outboundBuf);
    }
}
