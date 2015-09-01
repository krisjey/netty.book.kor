package com.github.nettybook.ch9;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class ApiServer {
    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress address;

    @Autowired
    @Qualifier("workerThreadCount")
    private int workerThreadCount;

    @Autowired
    @Qualifier("bossThreadCount")
    private int bossThreadCount;

    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(bossThreadCount);
        EventLoopGroup workerGroup = new NioEventLoopGroup(workerThreadCount);
        ChannelFuture channelFuture = null;

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ApiServerInitializer(null));

            Channel ch = b.bind(8080).sync().channel();

            channelFuture = ch.closeFuture();
            channelFuture.sync();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    // private ChannelFuture initializeServerNetworkBySSL(EventLoopGroup
    // bossGroup, EventLoopGroup workerGroup, int listenPort) throws
    // InterruptedException {
    // SslContext sslCtx = null;
    //
    // try {
    // File certChainFile =
    // ConfigReader.getInstance().getConfigFile(CoreConstantsName.SSL_PUBLIC_KEY);
    // File keyFile =
    // ConfigReader.getInstance().getConfigFile(CoreConstantsName.SSL_PRIVATE_KEY);
    //
    // sslCtx = SslContext.newServerContext(certChainFile, keyFile, null);
    // }
    // catch (SSLException | FileNotFoundException e) {
    // logger.error(e);
    // }
    //
    // ServerBootstrap b = new ServerBootstrap();
    // b.group(bossGroup, workerGroup)
    // .channel(NioServerSocketChannel.class)
    // .handler(new LoggingHandler(LogLevel.INFO))
    // .childHandler(new BigbrotherServerInitializer(sslCtx));
    //
    // Channel ch = b.bind(listenPort + 1000).sync().channel();
    //
    // ChannelFuture channelFuture = null;
    // channelFuture = ch.closeFuture();
    //
    // logger.info(DisplayForLog.makeFooter());
    //
    // return channelFuture;
    // }
}