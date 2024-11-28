package com.ct.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@EqualsAndHashCode(exclude = "author")
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String isbn;
    private String title;
    private String language;
    private String genre;
    @Column(name = "published_dt")
    private LocalDate publishedDate;
    private double price;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
