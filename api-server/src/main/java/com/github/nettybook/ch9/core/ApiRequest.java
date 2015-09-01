package com.github.nettybook.ch9.core;

import com.github.nettybook.ch9.service.RequestParamException;
import com.github.nettybook.ch9.service.ServiceException;
import com.google.gson.JsonObject;

/**
 * API Service request worker interface
 * 
 * @author kris
 */
public interface ApiRequest {
    /**
     * Request param null check method.
     * 
     * @throws RequestParamException
     */
    public void requestParamValidation() throws RequestParamException;

    /**
     * 서비스 구현
     * 
     * @throws Exception
     */
    public void service() throws ServiceException;

    /**
     * API서비스 호출시 실행.
     * 
     * @throws Exception
     */
    public void executeService();

    /**
     * API 서비스 수행 결과 조회.
     * 
     * @return
     */
    public JsonObject getApiResult();
}
