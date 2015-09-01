package com.github.nettybook.ch9.service.dao;

import redis.clients.util.MurmurHash;

import com.github.nettybook.ch9.core.KeyMaker;

public class TokenKey implements KeyMaker {
    static final int SEED_MURMURHASH = 0x1234ABCD;

    private String email;
    private long issueDate;

    /**
     * 키 메이커 클래스를 위한 생성자.
     * 
     * @param email
     *            키 생성을 위한 인덱스 값
     * @param issueDate
     */
    public TokenKey(String email, long issueDate) {
        this.email = email;
        this.issueDate = issueDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.redisbook.ch7.redislogger.KeyMaker#getKey()
     */
    @Override
    public String getKey() {
        String source = email + String.valueOf(issueDate);

        return Long.toString(MurmurHash.hash64A(source.getBytes(), SEED_MURMURHASH), 16);
    }
}