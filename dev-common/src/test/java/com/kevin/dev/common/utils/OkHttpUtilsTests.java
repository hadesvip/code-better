package com.kevin.dev.common.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * okHttp工具类测试
 * @author wangyong
 */
public class OkHttpUtilsTests {

    @Test
    public void getTest(){
        String resJson = OkHttpUtils.builder()
                .url("http://127.0.0.1:8080/user/queryUser/1312312")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("token", UUID.randomUUID().toString().replaceAll("-",""))
                .get()
                .sync();
        System.out.println(resJson);
    }


}
