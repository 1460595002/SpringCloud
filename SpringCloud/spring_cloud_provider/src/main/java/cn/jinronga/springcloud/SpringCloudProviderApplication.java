package cn.jinronga.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  @EnableDiscoveryClient: 启用发现服务功能，不局限于Eureka注册中心
 *  @EnableEurekaClient: 启用Eureka客户端功能，必须是Eureka注册中心
 *
 *   @EnableCircuitBreaker: 启用断路器功能【服务熔断】
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProviderApplication.class, args);
	}
}
