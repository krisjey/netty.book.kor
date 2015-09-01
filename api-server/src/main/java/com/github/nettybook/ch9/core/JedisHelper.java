package com.github.nettybook.ch9.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisHelper {
    protected static final String REDIS_HOST = "127.0.0.1";
    // protected static final String REDIS_HOST = "192.168.56.1";
    protected static final int REDIS_PORT = 6379;
    private final Set<Jedis> connectionList = new HashSet<Jedis>();
    private final JedisPool pool;

    /**
     * 제디스 연결풀 생성을 위한 도우미 클래스 내부 생성자. 싱글톤 패턴이므로 외부에서 호출할 수 없다.
     */
    private JedisHelper() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(20);
        config.setBlockWhenExhausted(true);

        this.pool = new JedisPool(config, REDIS_HOST, REDIS_PORT);
    }

    /**
     * 싱글톤 처리를 위한 홀더 클래스, 제디스 연결풀이 포함된 도우미 객체를 반환한다.
     */
    private static class LazyHolder {
        @SuppressWarnings("synthetic-access")
        private static final JedisHelper INSTANCE = new JedisHelper();
    }

    /**
     * 싱글톤 객체를 가져온다.
     * 
     * @return 제디스 도우미객체
     */
    @SuppressWarnings("synthetic-access")
    public static JedisHelper getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 제디스 클라이언트 연결을 가져온다.
     * 
     * @return 제디스 객체
     */
    final public Jedis getConnection() {
        Jedis jedis = this.pool.getResource();
        this.connectionList.add(jedis);

        return jedis;
    }

    /**
     * 사용이 완료된 제디스 객체를 회수한다.
     * 
     * @param jedis
     *            사용 완료된 제디스 객체
     */
    final public void returnResource(Jedis jedis) {
        this.pool.returnResource(jedis);
    }

    /**
     * 제디스 연결풀을 제거한다.
     */
    final public void destoryPool() {
        Iterator<Jedis> jedisList = this.connectionList.iterator();
        while (jedisList.hasNext()) {
            Jedis jedis = jedisList.next();
            this.pool.returnResource(jedis);
        }

        this.pool.destroy();
    }
}