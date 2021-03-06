package com.jeeplus.modules.activitymusic.util;

import org.apache.avalon.framework.logger.Logger;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * HttpRequestUtils工具类，包括post请求和get请求
 *
 * @author itguang
 * @create 2017-12-06 10:30
 **/
public class HttpRequestUtils {

    /**
     * getHttp
     * @param url
     * @return
     */
    public String getHttp(String url){
        String str=null;
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON);
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        HttpEntity<String> entity = new HttpEntity<String>("body", headers);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        str=exchange.getBody();
        return str;
    }
    /**
     * postHttp
     * @param url
     * @return
     */
    public String postHttp(String url){
       /* GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        Map<String, Object> map = g.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());*/
        String str=null;
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*//*
        HttpEntity<String> entity = new HttpEntity<String>(headers);
       ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
       str=exchange.getBody();
        return str;
    }
}