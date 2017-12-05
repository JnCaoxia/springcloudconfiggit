package com.caox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
// 启动类添加@EnableDiscoveryClient激活对配置中心的支持
public class SpringCloudConfigServer2EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServer2EurekaApplication.class, args);
	}
}
