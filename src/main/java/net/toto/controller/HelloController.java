package net.toto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@PostMapping("log-test")
	public void logTest() {
		LOGGER.trace("Trace Log >>>>>>");
		LOGGER.debug("Debug Log >>>>>");
		LOGGER.info("Info Log   >>>>");
		LOGGER.warn("Warn Log   >>>");
		LOGGER.error("Error Log >>");
	}
}
