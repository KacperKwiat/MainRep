package pl.edu.pjwstk.booksmpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.model.enums.BookType;
import pl.edu.pjwstk.booksmpr.service.AuthorService;
import pl.edu.pjwstk.booksmpr.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book/")
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Book> getBookByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    //http://localhost:8080/book/?id=0
    @DeleteMapping
    public ResponseEntity<String> deleteAuthorById(@RequestParam("id") Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("ok");
    }


    //http://localhost:8080/book/0
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    //http://localhost:8080/book/?type=DRAMA
    @GetMapping("/type")
    public ResponseEntity<List<Book>> findBooksByBookType(@RequestParam(name = "type")BookType bookType){
        return ResponseEntity.ok(bookService.findBooksByBookType(bookType));
    }

}
