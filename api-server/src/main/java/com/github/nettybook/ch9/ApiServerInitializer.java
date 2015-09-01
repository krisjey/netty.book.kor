package com.github.nettybook.ch9;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.ssl.SslContext;

import com.github.nettybook.ch9.core.ApiRequestParser;

public class ApiServerInitializer extends ChannelInitializer<SocketChannel> {
    private final SslContext sslCtx;

    public ApiServerInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        if (sslCtx != null) {
            p.addLast(sslCtx.newHandler(ch.alloc()));
        }

        p.addLast(new HttpRequestDecoder());
        // Uncomment the following line if you don't want to handle HttpChunks.
        p.addLast(new HttpObjectAggregator(65536));
        p.addLast(new HttpResponseEncoder());
        // Remove the following line if you don't want automatic content
        // compression.
        p.addLast(new HttpContentCompressor());
        p.addLast(new ApiRequestParser());
    }
}