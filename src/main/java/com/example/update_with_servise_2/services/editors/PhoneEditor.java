package com.example.update_with_servise_2.services.editors;

import com.example.update_with_servise_2.models.Phone;
import com.example.update_with_servise_2.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PhoneEditor extends PropertyEditorSupport{
    @Autowired
    private PhoneService phoneService;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Phone phone = new Phone();
        phone.setName(text);
        phoneService.save(phone);
        setValue(phone);
    }
}
