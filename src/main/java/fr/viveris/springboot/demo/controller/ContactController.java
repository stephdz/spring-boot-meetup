package fr.viveris.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.viveris.springboot.demo.persistence.dao.ContactDao;
import fr.viveris.springboot.demo.persistence.model.Contact;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactDao contactDao;

    @GetMapping
    public List<Contact> findAllContacts() {
	return contactDao.findAll();
    }
}
