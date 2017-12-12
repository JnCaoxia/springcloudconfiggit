package com.caox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 支持网关路由
public class GatewayServiceZuulSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceZuulSimpleApplication.class, args);
	}
}
