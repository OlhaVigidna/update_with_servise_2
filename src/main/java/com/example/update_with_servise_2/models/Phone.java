package com.example.update_with_servise_2.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "contact")
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    Contact contact;

    public Phone(String name) {
        this.name = name;
    }
}
