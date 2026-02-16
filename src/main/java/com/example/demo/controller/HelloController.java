package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello", description = "Public hello endpoint")
public class HelloController {

	@GetMapping("/hello")
	@Operation(
		summary = "Returns Hello World",
		description = "Public endpoint that returns a message payload.",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "Successful response",
				content = @Content(schema = @Schema(implementation = HelloResponse.class)))
		})
	public HelloResponse hello() {
		return new HelloResponse("Hello World");
	}

	public record HelloResponse(String message) {
	}
}
