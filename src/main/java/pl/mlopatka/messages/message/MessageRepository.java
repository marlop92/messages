package pl.mlopatka.messages.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByAuthor(String author);

    List<Message> findByAuthorInOrderByCreationTime(List<String> author);
}
