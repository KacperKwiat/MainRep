package pl.edu.pjwstk.booksmpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author findByNameAndLastName(String firstName, String lastName){
        Optional<Author> author = authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName);
        if(author.isPresent()){
            return author.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.getReferenceById(id);
    }

    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }
}
