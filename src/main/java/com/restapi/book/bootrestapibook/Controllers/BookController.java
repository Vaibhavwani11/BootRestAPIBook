package com.restapi.book.bootrestapibook.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.book.bootrestapibook.Entities.Book;
import com.restapi.book.bootrestapibook.Services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //Request handlers:

    @RequestMapping(value = "/books", method=RequestMethod.GET)
    //@GetMapping("/books") -> this can be written
    //public List<Book> getBooks(){
    public ResponseEntity<List<Book>> getBooks(){
        
        // Book book = new Book();
        // book.setId(1);
        // book.setTitle("Learning SpringBootRestAPI");
        // book.setAuthor("LearnCodeWithDurgesh");

        List<Book> list = bookService.getAllBooks();

        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

        Book book = bookService.getBookById(id);

        if(book==null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(book));
        
        // return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        //TODO: process PUT request
        Book b = null;

        try{
            b = bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        // return b;
    }

    @DeleteMapping("/books/{id}")
    public boolean deleteBook(@PathVariable("id") int id){

        boolean b= bookService.deleteBook(id);
        return b;
    }

    @PutMapping("books/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        //TODO: process PUT request
        bookService.updateBook(book,id);

        return book;
    }
}
