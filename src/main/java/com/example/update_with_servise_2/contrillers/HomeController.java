package com.example.update_with_servise_2.contrillers;

import com.example.update_with_servise_2.models.Contact;
import com.example.update_with_servise_2.models.Phone;
import com.example.update_with_servise_2.services.ContactService;
import com.example.update_with_servise_2.services.PhoneService;
import com.example.update_with_servise_2.services.editors.PhoneEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        model.addAttribute("contact", new Contact("test", "test@test.com"));
        return "home";
    }

    @PostMapping("/saveContact")
    public String saveContact(Contact contact,
                              @RequestParam("picture") MultipartFile file) {
        contactService.transferFile(file);
        contact.setAvatar(file.getOriginalFilename());
        contactService.save(contact);

//        Phone phone = new Phone(num);
//        phone.setContact(contact);
//        phoneService.save(phone);
        return "redirect:/";
    }

    @GetMapping("/details-{xxx}")
    public String details(@PathVariable("xxx") int id, Model model) {
        Contact one = contactService.findOne(id);
        model.addAttribute("contact", one);
        return "contact";
    }

    @PostMapping("/updateContact")
    public String updateContact(Contact contact) {
//        contactService.save(contact);
        return "redirect:/";
    }

    @Autowired
    private PhoneEditor phoneDoctor;

    @InitBinder("contact")
    public void initBinder(WebDataBinder binder) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        binder.registerCustomEditor(Phone.class, phoneDoctor);
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
