package pl.edu.pjwstk.booksmpr.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.model.enums.BookType;
import pl.edu.pjwstk.booksmpr.repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    BookService bookService;
    @Mock
    BookRepository bookRepository;
    @Mock
    AuthorService authorService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository, authorService);
    }

    @Test
    void Should_CreateBookWithCorrectInputAuthorNotExist() {
        //given
        Author a = new Author();
        Book expected_book = new Book("tytul", LocalDate.MAX, BookType.ACTION, a);
        //when
        when(authorService.createAuthor(a))
                .thenReturn(a);
        when(bookRepository.save(any()))
                .thenReturn(expected_book);
        //then
        assertEquals(expected_book, bookService.createBook(expected_book));
    }

    @Test
    void Should_CreateBookWithCorrectInputAuthorExist() {
        //given
        Author a = new Author(99L, "Adam", "Adamowicz");
        Book expected_book = new Book("tytul", LocalDate.MAX, BookType.ACTION, a);
        //when
        when(authorService.getAuthorById(a.getId()))
                .thenReturn(a);
        when(bookRepository.save(any()))
                .thenReturn(expected_book);
        //then
        assertEquals(expected_book, bookService.createBook(expected_book));
    }

    @Test
    void Should_ReturnAllBooks() {
        //given
        List<Book> books_expected = new ArrayList<>();
        books_expected.add(new Book());
        books_expected.add(new Book());
        books_expected.add(new Book());
        //when
        when(bookRepository.findAll()).thenReturn(books_expected);
        //then
        assertEquals(books_expected, bookService.getBooks());
    }

    @Test
    void Should_ReturnBookWithCorrectInput() {
        //given
        Book book_expected = new Book();
        //when
        when(bookRepository.findById(99L))
                .thenReturn(Optional.of(book_expected));
        //then
        assertEquals(book_expected, bookService.getBookById(99L));
    }

    @Test
    void Should_UpdateBookWithCorrectInput() {
        //given
        Book expected_book = new Book("tytul", LocalDate.MAX, BookType.ACTION, new Author());
        //when
        when(bookRepository.findById(99L))
                .thenReturn(Optional.of(new Book()));
        when(bookRepository.save(any(Book.class)))
                .thenReturn(expected_book);
        //then
        Book updatedBook = bookService.updateBook(99L, expected_book);
        assertEquals(expected_book, updatedBook);
    }

    @Test
    void findBooksByBookType() {
        //given
        List<Book> books_expected = new ArrayList<>();
        books_expected.add(new Book("tytul", LocalDate.MAX, BookType.ACTION, new Author()));
        books_expected.add(new Book("tytul", LocalDate.MAX, BookType.ACTION, new Author()));
        books_expected.add(new Book("tytul", LocalDate.MAX, BookType.ACTION, new Author()));
        //when
        when(bookRepository.findBooksByBookType(BookType.ACTION))
                .thenReturn(books_expected);
        //then
        assertEquals(books_expected, bookService.findBooksByBookType(BookType.ACTION));
    }
}