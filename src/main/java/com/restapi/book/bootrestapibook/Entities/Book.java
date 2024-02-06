package com.restapi.book.bootrestapibook.Entities;

// import org.hibernate.dialect.MySQLDialect;

// import jakarta.annotation.Generated;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;


// @Entity
// @Table(name = "books")
public class Book {

    // @Id //to make it primary key
    // @GeneratedValue(strategy =  GenerationType.AUTO) //To auto-generate & increment the id
    // @Column(name = "books_id")
    private int id;
    
    private String title;
    private String author;
    
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    
}
