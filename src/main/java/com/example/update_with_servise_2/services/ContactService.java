package com.example.update_with_servise_2.services;

import com.example.update_with_servise_2.dao.ContactDAO;
import com.example.update_with_servise_2.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactDAO contactDAO;

    public void save(Contact contact){
        contactDAO.save(contact);
    }

    public List<Contact> findAll(){
        return contactDAO.findAll();
    }

    public Contact findOne(int id){
        return contactDAO.getOne(id);
    }

}
