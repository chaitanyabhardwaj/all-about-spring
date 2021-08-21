package com.example.hellospring.bootstrap;

import com.example.hellospring.model.Author;
import com.example.hellospring.model.Book;
import com.example.hellospring.model.Publisher;
import com.example.hellospring.repository.PublisherRepository;
import com.example.hellospring.repository.AuthorRepository;
import com.example.hellospring.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    final private AuthorRepository authorRepository;
    final private BookRepository bookRepository;
    final private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args)throws Exception {
        Author tolkien = new Author("J. R. R", "Tolkien");
        Author sin = new Author("R. H.", "Sin");
        Book hobbit = new Book("The Hobbit", "0123456789");
        Book sfitw = new Book("She fits inside these words", "9876543210");
        Publisher aAu = new Publisher("Allen & Unwin", "Australia");
        Publisher andrew = new Publisher("Andrews McMeel", "United States");
        //save into repo
        publisherRepository.save(aAu);
        publisherRepository.save(andrew);
        //add books to authors
        tolkien.getBooks().add(hobbit);
        sin.getBooks().add(sfitw);
        //add authors
        hobbit.getAuthor().add(tolkien);
        sfitw.getAuthor().add(sin);
        //add publisher
        hobbit.setPublisher(aAu);
        sfitw.setPublisher(andrew);
        //add books to publishers
        aAu.getBooks().add(hobbit);
        andrew.getBooks().add(sfitw);
        //update repo
        authorRepository.save(tolkien);
        authorRepository.save(sin);
        bookRepository.save(hobbit);
        bookRepository.save(sfitw);
        publisherRepository.save(aAu);
        publisherRepository.save(andrew);
        //output
        System.out.println("Started in bootstrap");
        System.out.println("Number of books : " + bookRepository.count());
        System.out.println("Number of authors : " + authorRepository.count());
        System.out.println("Number of publishers : " + publisherRepository.count());
    }
}
