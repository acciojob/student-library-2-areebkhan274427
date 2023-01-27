//package com.driver.services;
//
//import com.driver.models.Author;
//import com.driver.models.Book;
//import com.driver.repositories.AuthorRepository;
//import com.driver.repositories.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BookService {
//
//
//    @Autowired
//    BookRepository bookRepository2;
//
//    @Autowired
//    AuthorRepository authorRepository;
//
//    public void createBook(Book book){
////        int id =book.getAuthor().getId();
////        Author author=authorRepository.findById(id).get();
////        book.setAuthor(author);
////
////        List<Book> currentBooks=author.getBooksWritten();
////        currentBooks.add(book);
////        author.setBooksWritten(currentBooks);
////
////        authorRepository.save(author);
//
//        bookRepository2.save(book);
//
//        //bookRepository2.save(book);
//    }
//
//    public List<Book> getBooks(String genre, boolean available, String author){
//
//
//        if(genre!=null && author!=null){
//            return bookRepository2.findBooksByGenreAuthor(genre, author, available);
//        }
//        else if(genre!=null){
//            return bookRepository2.findBooksByGenre(genre,available);
//        }
//        else if(author!=null){
//            return bookRepository2.findBooksByAuthor(author,available);
//        }
//        else
//            return bookRepository2.findByAvailability(available);
//    }
//}







package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;
    @Autowired
    private AuthorRepository authorRepository;

    public void createBook(Book book){

        try
        {
            int authorId = book.getAuthor().getId();
            Author author = authorRepository.findById(authorId).get();
            List<Book> bookList = author.getBooksWritten();
            if(bookList==null) {
                bookList = new ArrayList<>();
            }
            bookList.add(book);
            book.setAuthor(author);
            author.setBooksWritten(bookList);
            authorRepository.save(author);
        }
        catch(Exception e) {
            bookRepository2.save(book);
        }
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books;

        if(genre != null && author != null){
            books = bookRepository2.findBooksByGenreAuthor(genre, author, available);
        }else if(genre != null){
            books = bookRepository2.findBooksByGenre(genre, available);
        }else if(author != null){
            books = bookRepository2.findBooksByAuthor(author, available);
        }else{
            books = bookRepository2.findByAvailability(available);
        }
        return books;
    }
}




