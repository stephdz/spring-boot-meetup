package fr.viveris.springboot.demo.controller;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import fr.viveris.springboot.demo.persistence.dao.ContactDao;
import fr.viveris.springboot.demo.persistence.model.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactDao contactDao;

    @Test
    public void shouldReturnAllContacts() throws Exception {

	// Arrange : un contact dans la base de données
	Contact contact = new Contact(1, "MARTIN", "Jean", "jean.martin@viveris.fr");
	Mockito.when(contactDao.findAll()).thenReturn(Arrays.asList(contact));

	// Act : récupération des contacts
	// Assert : il doit y avoir MARTIN
	mockMvc.perform(MockMvcRequestBuilders.get("/api/contacts")).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("MARTIN")));
    }
}
