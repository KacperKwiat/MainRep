//package repository;
//
//import pl.edu.pjwstk.booksmpr.model.Author;
//import pl.edu.pjwstk.booksmpr.model.Book;
//import pl.edu.pjwstk.booksmpr.model.enums.BookType;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import pl.edu.pjwstk.booksmpr.repository.BookRepository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BookRepositoryTest {
//
//    BookRepository bookRepository;
//
//    @BeforeEach
//    void setUp() {
//        bookRepository = new BookRepository();
//    }
//
//    @Test
//    void Should_CreateBookWithCorrectInput() {
//        //given
//        Book b = new Book();
//        //when
//        b = bookRepository.createBook(b);
//        //then
//        assertNotNull(b.getId());
//    }
//
//    @Test
//    void Should_deleteBookWithCorrectInput() {
//        //given
//        bookRepository.createBook(new Book());
//        bookRepository.createBook(new Book());
//        bookRepository.createBook(new Book());
//        //when
//        bookRepository.deleteBook(0L);
//        //then
//        assertEquals(2, bookRepository.getAllBooks().size());
//    }
//
//    @Test
//    void Should_getBooksByIdWithProperInput() {
//        //given
//        bookRepository.createBook(new Book());
//        //when
//        Book b = bookRepository.getBookById(0L);
//        //then
//        assertNotNull(b);
//    }
//
//    @Test
//    void Should_throwIllegalArgumentExceptionWhenGettingBookWhichNotExist() {
//        //given
//        //when
//        //then
//        assertThrows(IllegalArgumentException.class, () -> bookRepository.getBookById(0L));
//    }
//
//    @Test
//    void Should_GetAllBooks() {
//        //give
//        List<Book> books;
//        //when
//        books = bookRepository.getAllBooks();
//        //then
//        assertNotNull(books);
//    }
//
//    @Test
//    void Should_UpdateBookWithProperInput() {
//        //given
//        Book b = new Book();
//        //when
//        bookRepository.createBook(b);
//        b = bookRepository.updateBook(0L, new Book("Pan Tadeusz", LocalDate.now(), BookType.ACTION, new Author()));
//        //then
//        assertEquals("Pan Tadeusz", b.getTitle());
//    }
//}