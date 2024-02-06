package com.restapi.book.bootrestapibook.Services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restapi.book.bootrestapibook.Entities.Book;
// import com.restapi.book.bootrestapibook.dao.BookRepository;

@Component //@Service can also be used
public class BookService {
    
    //can use the list and static block if we are not using jpa and just using the dummy data.
    private static List<Book> list = new ArrayList<Book>();

    //as class loads, this static block runs
    static{

        list.add(new Book(123, "Learn Static Block","Vaibhav"));
        list.add(new Book(124, "Learn Spring RestAPI","abc"));

    }

    //Using springBoot JPA
    // private BookRepository bookRepository;

    
    //get all Books
    public List<Book> getAllBooks(){
        
        return list;
    }
                                                                                                          
    //get single book by id
    public Book getBookById(int id){

        Book myBook = null;
        //Using Stream API
        try{
            myBook = list.stream()     
                        .filter(e -> e.getId()==id)
                        .findFirst()
                        .get();
        }
        catch(Exception e){

            e.printStackTrace();
        }
        return myBook;
    }

    //Add a book
    public Book addBook(Book b){

        list.add(b);
        return b;
    }

    //Delete a book
    public boolean deleteBook(int id){
        
        list = list.stream()
                    .filter(book -> book.getId() != id )
                    .collect(Collectors.toList());

        return true;
    }

    //Update the book
    public void updateBook(Book book, int id){

        list = list.stream()
                    .map(b -> {

                        if(b.getId() == id){

                            b.setTitle(book.getTitle());
                            b.setAuthor(book.getAuthor());
                        }
                        return b;
                    })
                    .collect(Collectors.toList());
            
        // .filter(book -> book.getId() == id)
            
        
        // return book;
    } 
}
