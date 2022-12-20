package pl.edu.pjwstk.booksmpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.model.enums.BookType;
import pl.edu.pjwstk.booksmpr.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        if(book.getAuthor() != null){
            if(book.getAuthor().getId() == null || authorService.getAuthorById(book.getAuthor().getId()) == null){
                book.setAuthor(authorService.createAuthor(book.getAuthor()));
            }else {
                book.setAuthor(authorService.getAuthorById(book.getAuthor().getId()));
            }
        }
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
//        return bookRepository.getReferenceById(id);
        Optional<Book> b = bookRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book bookToUpdate = getBookById(id);

        if (updatedBook.getPublisher() != null) {
            bookToUpdate.setPublisher(updatedBook.getPublisher());
        }

        if (updatedBook.getTitle() != null) {
            bookToUpdate.setTitle(updatedBook.getTitle());
        }

        if (updatedBook.getAuthor() != null) {
            bookToUpdate.setAuthor(updatedBook.getAuthor());
        }

        return bookRepository.save(bookToUpdate);

    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findBooksByBookType(BookType bookType) {
        return bookRepository.findBooksByBookType(bookType);
    }
}
