package com.github.nettybook.ch9.service;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;

import com.github.nettybook.ch9.core.ApiRequestTemplate;
import com.github.nettybook.ch9.core.JedisHelper;

@Service("tokenExpier")
@Scope("prototype")
public class TokenExpire extends ApiRequestTemplate {
    private static final JedisHelper helper = JedisHelper.getInstance();

    public TokenExpire(Map<String, String> reqData) {
        super(reqData);
    }

    @Override
    public void requestParamValidation() throws RequestParamException {
        if (StringUtils.isEmpty(this.reqData.get("token"))) {
            throw new RequestParamException("token이 없습니다.");
        }
    }

    @Override
    public void service() throws ServiceException {
        Jedis jedis = null;
        try {
            // token 저장.
            jedis = helper.getConnection();
            long result = jedis.del(this.reqData.get("token"));
            System.out.println(result);

            // helper.
            this.apiResult.addProperty("resultCode", "200");
            this.apiResult.addProperty("message", "Success");
            this.apiResult.addProperty("token", this.reqData.get("token"));
        }
        catch (Exception e) {
            helper.returnResource(jedis);
        }
    }
}
