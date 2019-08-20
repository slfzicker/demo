//package com.cy.config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.profile.IClientProfile;
//
//@Configuration
//@PropertySource("classpath:/conf/aliyun-verify-test.properties")
//public class WebConfigure {
//    @Value("${aliyun.verify.regionid}")
//    private String regionid;
//    @Value("${aliyun.verify.accessKeyId}")
//    private String accessKeyId;
//    @Value("${aliyun.verify.accessKeySecret}")
//    private String accessKeySecret;
//    @Bean
//    public IAcsClient client() throws Exception {
//        IClientProfile profile = DefaultProfile.getProfile(regionid, accessKeyId, accessKeySecret);
//        IAcsClient client = new DefaultAcsClient(profile);
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "afs", "afs.aliyuncs.com");
//        return client;
//    }
//}