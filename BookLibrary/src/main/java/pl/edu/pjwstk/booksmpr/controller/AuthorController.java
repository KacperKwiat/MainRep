package pl.edu.pjwstk.booksmpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.service.AuthorService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/author/")
public class AuthorController {
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.createAuthor(author));
    }
    //http://localhost:8080/author/1
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    //http://localhost:8080/author/get?id=2
    @GetMapping("/get")
    public ResponseEntity<Author> getAuthorByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAuthorById(@PathVariable("id") Long id){
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok("ok");
    }

}
