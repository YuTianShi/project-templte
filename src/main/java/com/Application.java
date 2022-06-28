package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DemoApplication.
 *
 * @author qr xun 2019/7/2 14:32
 */
@SpringBootApplication(scanBasePackages = { "com" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
