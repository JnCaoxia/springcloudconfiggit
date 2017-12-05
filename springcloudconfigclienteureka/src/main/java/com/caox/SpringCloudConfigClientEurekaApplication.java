package com.caox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // @EnableDiscoveryClient激活对配置中心的支持
@SpringBootApplication
public class SpringCloudConfigClientEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientEurekaApplication.class, args);
	}
}
