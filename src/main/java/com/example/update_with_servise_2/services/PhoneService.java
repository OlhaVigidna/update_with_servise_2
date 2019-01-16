package com.example.update_with_servise_2.services;

import com.example.update_with_servise_2.dao.PhoneDAO;
import com.example.update_with_servise_2.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneDAO phoneDAO;

    public void save(Phone phone){
        phoneDAO.save(phone);
    }

    public List<Phone> findAll(){
        return phoneDAO.findAll();
    }
}
