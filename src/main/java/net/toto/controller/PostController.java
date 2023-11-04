package net.toto.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.toto.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

  @PostMapping("/default")
  public String postMethod() {
    return "Hello World!";
  }

  // http://localhost:8080/api/v1/post-api/member
  /*
   * { "name":"TOTO", "email":"yoondaebae@gmail.com", "organization":"DaeKyo" }
   */
  @PostMapping("/member")
  public String postMember(@RequestBody Map<String, Object> postData) {
    StringBuilder sb = new StringBuilder();

    postData.entrySet().forEach(map -> {
      sb.append(map.getKey() + " : " + map.getValue() + "\n");
    });
    return sb.toString();
  }

  // http://localhost:8080/api/v1/post-api/member2
  /*
   * { "name":"TOTO", "email":"yoondaebae@gmail.com", "organization":"DaeKyo" }
   */
  @PostMapping("/member2")
  public String postMemberDto(@RequestBody MemberDTO memberDTO) {
    return memberDTO.toString();
  }
}
