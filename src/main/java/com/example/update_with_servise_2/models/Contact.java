package com.example.update_with_servise_2.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "phoneList")
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "contact"
    )
    List<Phone> phoneList = new ArrayList<>();
    String avatar;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
