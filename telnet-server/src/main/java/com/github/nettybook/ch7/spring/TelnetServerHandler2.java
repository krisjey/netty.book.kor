package com.github.nettybook.ch7.spring;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;
import java.util.Date;

@Sharable
public class TelnetServerHandler2 extends SimpleChannelInboundHandler<String> {
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// Send greeting for a new connection.
		ctx.write("환영합니다2. "
					+ InetAddress.getLocalHost().getHostName() + "에 접속하셨습니다!\r\n");
		ctx.write("현재 시간은 " + new Date() + " 입니다2.\r\n");
		ctx.flush();
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, String request)
			throws Exception {
		String response;
		boolean close = false;

		if (request.isEmpty()) {
			response = "명령을 입력해 주세요2.\r\n";
		}
		else if ("bye".equals(request.toLowerCase())) {
			response = "좋은 하루 되세요2!\r\n";
			close = true;
		}
		else {
			response = "입력하신 명령이 '" + request + "' 입니까2?\r\n";
		}

		ChannelFuture future = ctx.write(response);

		if (close) {
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
