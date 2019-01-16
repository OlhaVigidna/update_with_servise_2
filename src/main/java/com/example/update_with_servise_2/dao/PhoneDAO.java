package com.example.update_with_servise_2.dao;


import com.example.update_with_servise_2.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDAO extends JpaRepository<Phone, Integer> {
}
