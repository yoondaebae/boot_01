package net.toto.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.toto.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
	
	//http://localhost:8080/api/v1/put-api/default
	@PutMapping("/default")
	public String putMethod() {
		return "Hello World";
	}
	
	//http://localhost:8080/api/v1/put-api/member
	@PutMapping("/member")
	public String postMember(@RequestBody Map<String, Object> putData) {
		StringBuilder sb = new StringBuilder();
		
		putData.entrySet().forEach(map ->{
			sb.append(map.getKey()+" : "+ map.getValue()+"\n");
		});
		return sb.toString();
	}
	
	//http://localhost:8080/api/v1/put-api/member1
	/*
	 * { "name":"TOTO", "email":"yoondaebae@gmail.com", "organization":"DaeKyo" }
	 */
	@PostMapping("/member1")
	public String putMemberDto1(@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
	//http://localhost:8080/api/v1/put-api/member1
	/*
	 * { "name":"TOTO", "email":"yoondaebae@gmail.com", "organization":"DaeKyo" }
	 */
	@PostMapping("/member2")
	public String putMemberDto2(@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
	//http://localhost:8080/api/v1/put-api/member2
	/*
	 * { "name":"TOTO", "email":"yoondaebae@gmail.com", "organization":"DaeKyo" }
	 */
	@PostMapping("/member3")
	public ResponseEntity<MemberDTO> putMemberDto3(@RequestBody MemberDTO memberDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
	}
}
