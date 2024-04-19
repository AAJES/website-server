package com.ajes.controller;

import com.ajes.model.Contact;
import com.ajes.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ajes")
@CrossOrigin(origins="https://project-client-kappa.vercel.app/")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public Contact addContact(@RequestBody() Contact contact){

        return contactService.addContact(contact);
    }

    @GetMapping("/contact/")
    public List<Contact> getAllContacts(){

        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{contactId}")
    public Contact getById(@PathVariable() Integer contactId)
    {
        return contactService.getContactById(contactId);
    }

    @DeleteMapping("/contact/{contactId}")
    public Contact deleteById(@PathVariable() Integer contactId){
//        Contact contact = contactService.deleteContactById(contactId);
//        return contact;
        return contactService.deleteContactById(contactId);
    }

    @PutMapping("/contact/{contactId}")
    public Contact updateById(@RequestBody() Contact contact,@PathVariable() Integer contactId){
        return contactService.updateContactById(contactId,contact);
    }

}
