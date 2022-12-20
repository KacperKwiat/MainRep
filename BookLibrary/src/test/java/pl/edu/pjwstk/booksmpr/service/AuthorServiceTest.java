package pl.edu.pjwstk.booksmpr.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    AuthorService authorService;
    @Mock
    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorService = new AuthorService(authorRepository);
    }

    @Test
    void Should_CreateAuthorWithCorrectInput() {
        //given
        Author a = new Author();
        //when
        when(authorRepository.save(any())).thenReturn(new Author(99L, "Adam", "Adamowicz"));
        a = authorService.createAuthor(a);
        //then
        assertEquals("Adam", a.getFirstName());
        assertEquals("Adamowicz", a.getLastName());
    }

    @Test
    void Should_ThrowIllegalArgumentExceptionWhenNotFound() {
        //given

        //when
        when(authorRepository.findAuthorByFirstNameAndLastName(anyString(), anyString()))
                .thenReturn(Optional.empty());
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            authorService.findByNameAndLastName(anyString(), anyString());
        });
    }

    @Test
    void Should_RerunAllAuthors() {
        //given
        List<Author> authors_expected = new ArrayList<>();
        authors_expected.add(new Author());
        authors_expected.add(new Author());
        authors_expected.add(new Author());
        //when
        when(authorRepository.findAll())
                .thenReturn(authors_expected);
        List<Author> authors_actual = authorService.getAllAuthors();
        //then
        assertEquals(authors_expected, authors_actual);

    }

    @Test
    void Should_ReturnOneAuthorWithCorrectInput() {
        //given
        Author author_expected = new Author(1L, "Adam", "Adamowicz");
        //when
        when(authorRepository.getReferenceById(anyLong()))
                .thenReturn(author_expected);
        Author author_actual = authorService.getAuthorById(1L);
        //then
        assertEquals(author_expected, author_actual);
    }

}