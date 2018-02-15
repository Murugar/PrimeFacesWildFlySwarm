package com.iqmsoft.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.iqmsoft.domain.Magazine;
import com.iqmsoft.service.MagService;


@Model
public class MagController {
    
    private Magazine mag;
    
    @PostConstruct
    private void init() {
        mag = new Magazine();
        System.out.println("com.iqmsoft.controller.MagController.init()");
    }
    
    @Inject
    private MagService bookService;
    
    public void saveBook() {
        bookService.addBook(mag);
        mag = new Magazine();
        System.out.println("com.iqmsoft.controller.MagController.saveBook()");
    }
    
    public List<Magazine> getBooks() {
        return bookService.getBooks();
    }

    public Magazine getBook() {
        return mag;
    }

    public void setBook(Magazine book) {
        this.mag = book;
    }
}
