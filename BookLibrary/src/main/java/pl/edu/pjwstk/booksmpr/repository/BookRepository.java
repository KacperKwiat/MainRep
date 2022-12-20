package pl.edu.pjwstk.booksmpr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.model.enums.BookType;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByBookType(BookType bookType);

}
