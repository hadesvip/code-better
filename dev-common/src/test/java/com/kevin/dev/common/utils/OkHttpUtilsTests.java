package com.kevin.dev.common.utils;

import okhttp3.Call;
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


    @Test
    public void postTest(){
        OkHttpUtils.builder().url("请求地址，http/https都可以")
                // 有参数的话添加参数，可多个
                .addParam("参数名", "参数值")
                .addParam("参数名", "参数值")
                // 也可以添加多个
                .addHeader("Content-Type", "application/json; charset=utf-8")
                // 如果是true的话，会类似于postman中post提交方式的raw，用json的方式提交，不是表单
                // 如果是false的话传统的表单提交
                .post(true)
                .sync();

        // 选择异步有两个方法，一个是带回调接口，一个是直接返回结果
        OkHttpUtils.builder().url("")
                .post(false)
                .async();

        OkHttpUtils.builder().url("").post(false).async(new OkHttpUtils.CallBack() {
            @Override
            public void onSuccessful(Call call, String data) {

            }

            @Override
            public void onFailure(Call call, String errorMsg) {
                // 请求失败后的处理
            }
        });
    }


}
