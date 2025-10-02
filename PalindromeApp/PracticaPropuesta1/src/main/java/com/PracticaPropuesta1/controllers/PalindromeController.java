package com.PracticaPropuesta1.controllers;

import com.PracticaPropuesta1.dto.PalindromeResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class PalindromeController {

  @GetMapping("/palindrome")
  public PalindromeResponse check(@RequestParam String word) {
    boolean result = isPalindrome(word);
    return new PalindromeResponse(word, result);
  }

  /**
   * Método para verificar si una palabra es un palíndromo
   */
  private boolean isPalindrome(String word) {
    int length = word.length();
    for (int i = 0; i < length / 2; i++) {
      if (word.charAt(i) != word.charAt(length - i - 1)) {
        return false;
      }
    }
    return true;
  }
}



