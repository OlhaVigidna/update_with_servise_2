package com.example.update_with_servise_2.services;

import com.example.update_with_servise_2.dao.ContactDAO;
import com.example.update_with_servise_2.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public void transferFile(MultipartFile file)  {
        String pathToFolder = System.getProperty("user.home") + File.separator + "images" + File.separator;
        try {
            file.transferTo(new File(pathToFolder + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
