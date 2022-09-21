package com.kevin.dev.common;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class BufferTest {


    @Test
    public void parseBufferTest() {
        try (FileInputStream fis = new FileInputStream("/Users/wangyong/Pictures/电脑桌面.png")) {
            //生成ByteBuffer代码，包括填充数据
            FileChannel fileChannel = fis.getChannel();
            long capacity = fileChannel.size();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) capacity);
            fileChannel.read(byteBuffer);

            //只需要关注这个代码
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());

            //以下皆是测试验证逻辑
            int size = byteArrayInputStream.available();
            byte[] byteArray = new byte[size];
            byteArrayInputStream.read(byteArray, 0, size);
            //encode base64
            String encode = Base64.getEncoder().encodeToString(byteArray);
            Logger.getGlobal().info("String value:" + encode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
