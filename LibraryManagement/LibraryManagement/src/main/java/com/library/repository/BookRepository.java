package com.library.repository;

import org.springframework.stereotype.Repository;
@Repository
public class BookRepository {
    // Repository methods for managing books in the library

    public void getBook(){
      System.out.println("BookRepository");
    }
}