package pl.mlopatka.messages.message;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "creation_time", nullable = false)
    private ZonedDateTime creationTime;

    @Column(name = "text", nullable = false)
    private String text;
}
