package fr.viveris.springboot.demo.persistence.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.viveris.springboot.demo.persistence.model.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactDaoTest {

    @Autowired
    private ContactDao contactDao;

    @Test
    public void testFindAll() {

	// Arrange : un contact en base

	// Act : récupération de tous les contacts
	List<Contact> contacts = contactDao.findAll();

	// Assert : je dois avoir Stéphane
	Assert.assertEquals("Stéphane", contacts.get(0).getPrenom());
    }
}
