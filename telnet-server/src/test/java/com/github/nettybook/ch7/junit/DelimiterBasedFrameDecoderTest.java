/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.github.nettybook.ch7.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;

import java.nio.charset.Charset;

import org.junit.Test;

public class DelimiterBasedFrameDecoderTest {
    @Test
    public void testDecoder() {
        String writeData = "안녕하세요\r\n반갑습니다\r\n";
        String firstResponse = "안녕하세요\r\n";
        String secondResponse = "반갑습니다\r\n";

        DelimiterBasedFrameDecoder decoder = new DelimiterBasedFrameDecoder(8192, 
                false, Delimiters.lineDelimiter());
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(decoder);

        ByteBuf request = Unpooled.wrappedBuffer(writeData.getBytes());
        boolean result = embeddedChannel.writeInbound(request);
        assertTrue(result);

        ByteBuf response = null;

        response = (ByteBuf) embeddedChannel.readInbound();
        assertEquals(firstResponse, response.toString(Charset.defaultCharset()));

        response = (ByteBuf) embeddedChannel.readInbound();
        assertEquals(secondResponse, response.toString(Charset.defaultCharset()));

        embeddedChannel.finish();
    }
}
