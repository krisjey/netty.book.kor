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
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.base64.Base64Encoder;

import java.nio.charset.Charset;

import org.junit.Test;

public class Base64EncoderTest {
    @Test
    public void testEncoder() {
        String writeData = "안녕하세요";
        ByteBuf request = Unpooled.wrappedBuffer(writeData.getBytes());

        Base64Encoder encoder = new Base64Encoder();
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(encoder);

        embeddedChannel.writeOutbound(request);
        ByteBuf response = (ByteBuf) embeddedChannel.readOutbound();

        String expect = "7JWI64WV7ZWY7IS47JqU";
        assertEquals(expect, response.toString(Charset.defaultCharset()));

        embeddedChannel.finish();
    }
}
