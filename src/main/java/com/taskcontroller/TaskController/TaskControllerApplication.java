package com.taskcontroller.TaskController;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "default server url")})
@SpringBootApplication
public class TaskControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskControllerApplication.class, args);
	}

}
