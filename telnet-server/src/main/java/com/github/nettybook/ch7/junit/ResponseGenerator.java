package com.github.nettybook.ch7.junit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class ResponseGenerator {
    private String request;

    public ResponseGenerator(String request) {
        this.request = request;
    }

    public final String response() {
        String command = null;

        if (this.request.isEmpty()) {
            command = "명령을 입력해 주세요.\r\n";
        }
        else if ("bye".equals(this.request.toLowerCase())) {
            command = "좋은 하루 되세요!\r\n";
        }
        else {
            command = "입력하신 명령이 '" + request + "' 입니까?\r\n";
        }

        return command;
    }

    public boolean isClose() {
        return "bye".equals(this.request);
    }

    public static final String makeHello() throws UnknownHostException {
        StringBuilder builder = new StringBuilder();

        builder.append("환영합니다. ")
                .append(InetAddress.getLocalHost().getHostName())
                .append("에 접속하셨습니다!\r\n")
                .append("현재 시간은 ").append(new Date().toString())
                .append(" 입니다.\r\n");

        return builder.toString();
    }
}
