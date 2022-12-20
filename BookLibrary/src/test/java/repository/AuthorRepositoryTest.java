//package repository;
//
//import pl.edu.pjwstk.booksmpr.model.Author;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import pl.edu.pjwstk.booksmpr.repository.AuthorRepository;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AuthorRepositoryTest {
//
//    AuthorRepository authorRepository;
//
//    @BeforeEach
//    void setUp() {
//        authorRepository = new AuthorRepository();
//    }
//
//    @Test
//    void Should_CreateAuthorWithCorrectInput() {
//        //given
//        Author a = new Author();
//        //when
//        authorRepository.createAuthor(a);
//        //then
//        assertNotNull(a.getId());
//    }
//
//    @Test
//    void Should_GetAllAuthors() {
//        //give
//        List<Author> authors;
//        //when
//        authors = authorRepository.getAllAuthors();
//        //then
//        assertNotNull(authors);
//    }
//
//    @Test
//    void Should_deleteAuthorWithCorrectInput() {
//        //given
//        authorRepository.createAuthor(new Author());
//        authorRepository.createAuthor(new Author());
//        authorRepository.createAuthor(new Author());
//        //when
//        authorRepository.deleteAuthor(0L);
//        //then
//        assertEquals(2, authorRepository.getAllAuthors().size());
//    }
//
//    @Test
//    void Should_getAuthorByIdWithProperInput() {
//        //given
//        authorRepository.createAuthor(new Author());
//        //when
//        Author a = authorRepository.getAuthorById(0L);
//        //then
//        assertNotNull(a);
//    }
//
//    @Test
//    void Should_throwIllegalArgumentExceptionWhenGettingAuthorWhichNotExist() {
//        //given
//        //when
//        //then
//        assertThrows(IllegalArgumentException.class, () -> authorRepository.getAuthorById(0L));
//    }
//}