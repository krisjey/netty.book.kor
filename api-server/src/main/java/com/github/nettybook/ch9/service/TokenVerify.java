package com.github.nettybook.ch9.service;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;

import com.github.nettybook.ch9.core.ApiRequestTemplate;
import com.github.nettybook.ch9.core.JedisHelper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service("tokenVerify")
@Scope("prototype")
public class TokenVerify extends ApiRequestTemplate {
    private static final JedisHelper helper = JedisHelper.getInstance();

    public TokenVerify(Map<String, String> reqData) {
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
            jedis = helper.getConnection();
            String tokenString = jedis.get(this.reqData.get("token"));

            if (tokenString == null) {
                this.apiResult.addProperty("resultCode", "404");
                this.apiResult.addProperty("message", "Fail");
            }
            else {
                Gson gson = new Gson();
                JsonObject token = gson.fromJson(tokenString, JsonObject.class);

                // helper.
                this.apiResult.addProperty("resultCode", "200");
                this.apiResult.addProperty("message", "Success");
                this.apiResult.add("issueDate", token.get("issueDate"));
                this.apiResult.add("email", token.get("email"));
                this.apiResult.add("userNo", token.get("userNo"));
            }

        }
        catch (Exception e) {
            helper.returnResource(jedis);
        }
    }
}
