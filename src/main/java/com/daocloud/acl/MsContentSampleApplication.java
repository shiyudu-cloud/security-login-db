package com.daocloud.acl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.daocloud.acl")
@SpringBootApplication
public class MsContentSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsContentSampleApplication.class, args);
	}

}
