package com.PracticaPropuesta1.controller;

import com.PracticaPropuesta1.dto.PalindromeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PalindromeControllerTest {

  @Autowired
  TestRestTemplate rest;

  @Test
  void ana_debe_ser_palindromo() {
    ResponseEntity<PalindromeResponse> res =
            rest.getForEntity("/palindrome?word=ana", PalindromeResponse.class);
    assertThat(res.getBody().palindrome()).isTrue();
    assertThat(res.getBody().word()).isEqualTo("ana");
  }

  @Test
  void hola_no_es_palindromo() {
    ResponseEntity<PalindromeResponse> res =
            rest.getForEntity("/palindrome?word=hola", PalindromeResponse.class);
    assertThat(res.getBody().palindrome()).isFalse();
  }
}