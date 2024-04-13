package com.ajes.service;

import com.ajes.model.Contact;
import com.ajes.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact addContact(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Contact getContactById(Integer contactId){
        return contactRepository.findById(contactId).get();
    }

    public Contact deleteContactById(Integer contactId){
        Contact contact = getContactById(contactId);
        contactRepository.deleteById(contactId);
        return contact;
    }

    public Contact updateContactById(Integer contactId,Contact contact){
        contact.setContactId(contactId);
        return contactRepository.save(contact);
    }
}
