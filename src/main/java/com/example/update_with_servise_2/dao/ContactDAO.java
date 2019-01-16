package com.example.update_with_servise_2.dao;

import com.example.update_with_servise_2.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDAO extends JpaRepository<Contact, Integer> {
}
