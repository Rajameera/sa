package com.demo.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${msg:DEfault value if not picked from config server}")
	private String msg;
	
	@Value("${commonValue:DEfault value if not picked from config server}")
	private String commonValue;

	@RequestMapping("/display")
	String getDisplay() {
		StringBuilder builder =new StringBuilder();
		builder.append("commonValue---------->"+ commonValue +"\n");
		builder.append("msg---------->"+ msg +"\n");
		return builder.toString();
	}
}