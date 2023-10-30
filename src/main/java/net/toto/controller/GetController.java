package net.toto.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.toto.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

	//http://localhost:8080/api/v1/get-api/hello
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String getHello() {
		return "Hello World";
	}
	
	//http://localhost:8080/api/v1/get-api/name
	@GetMapping("/name")
	public String getName() {
		return "TOTO";
	}
	
	//http://localhost:8080/api/v1/get-api/variable1/springbootTest
	@GetMapping("/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		return variable;
	}
	
	//http://localhost:8080/api/v1/get-api/variable2/springbootTest2
	@GetMapping("/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		return var;
	}
	
	//http://localhost:8080/api/v1/get-api/request1?
	//name=TOTO&
	//email=yoondaebae@gmail.com&
	//organization=DaeKyo
	@GetMapping("/request1")
	public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
		return name +" / "+email +" / "+organization;
	}
	
	//http://localhost:8080/api/v1/get-api/request2?
	//key1=TOTO&
	//key2=yoondaebae@gmail.com&
	//key3=DaeKyo
	@GetMapping("/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		
		StringBuilder sb = new StringBuilder();
		
		param.entrySet().forEach(map ->{
			sb.append(map.getKey()+" : "+ map.getValue()+"\n");
		});
		return sb.toString();
	}
	
	//http://localhost:8080/api/v1/get-api/request3?
	//name=TOTO&
	//email=yoondaebae@gmail.com&
	//organization=DaeKyo
	@GetMapping("/request3")
	public String getRequestParam3(MemberDTO memberDTO) {
		return memberDTO.toString();
	}
}
