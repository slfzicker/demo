package com.alibaba.test;

import org.junit.BeforeClass;
import org.junit.Test;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.afs.model.v20180112.AuthenticateSigRequest;
import com.aliyuncs.afs.model.v20180112.AuthenticateSigResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
/**
 * 
 */
public class TestAfsCheck {

    IAcsClient client = null;

    @BeforeClass
    public void setUp() throws Exception {
        //YOUR ACCESS_KEY、YOUR ACCESS_SECRET请替换成您的阿里云accesskey id和secret 
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIzMrRaLU5A7Rh", "ev4r7GPHm5u2A4idHPjMqozmy277iP");
        client = new DefaultAcsClient(profile);

        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "afs", "afs.aliyuncs.com");
    }

    @Test
    public void test(){        
        AuthenticateSigRequest request = new AuthenticateSigRequest();
        request.setSessionId("xxx");// 必填参数，从前端获取，不可更改，android和ios只传这个参数即可
        request.setSig("xxx");// 必填参数，从前端获取，不可更改
        request.setToken("xxx");// 必填参数，从前端获取，不可更改
        request.setScene("xxx");// 必填参数，从前端获取，不可更改
        request.setAppKey("xxx");// 必填参数，后端填写
        request.setRemoteIp("xxx");// 必填参数，后端填写

        try {
                AuthenticateSigResponse response = client.getAcsResponse(request);
                if(response.getCode() == 100) {
                    System.out.println("验签通过");
                } else {
                    System.out.println("验签失败");
                }
            // TODO
        } catch (Exception e) {
            e.printStackTrace();            
        }        
    }
}