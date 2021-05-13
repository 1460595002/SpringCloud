package cn.jinronga.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @Author 郭金荣
 * @Date 2021/5/11 20:37
 * @Description RestTemplateConfig
 * @Version 1.0
 */
@Configuration
public class RestTemplateConfig {
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
