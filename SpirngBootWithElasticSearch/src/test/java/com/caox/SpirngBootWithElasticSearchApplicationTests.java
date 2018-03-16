package com.caox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpirngBootWithElasticSearchApplicationTests {

	@Test
	public void contextLoads() {

	}

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = SpirngBootWithElasticSearchApplicationTests.class.getClassLoader();
		System.out.println(loader);
		//使用ClassLoader.loadClass()来加载类，不会执行初始化块
//		loader.loadClass("com.caox.Test2");
		//使用Class.forName()来加载类，默认会执行初始化块
//		Class.forName("com.caox.Test2");
		//使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
		Class.forName("com.caox.Test2", false, loader);
	}

}
