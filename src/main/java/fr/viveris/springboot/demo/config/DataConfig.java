package fr.viveris.springboot.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.viveris.springboot.demo.persistence.dao.ContactDao;
import fr.viveris.springboot.demo.persistence.model.Contact;

@Configuration
public class DataConfig {

    @Autowired
    private ContactDao contactDao;

    @Bean
    public CommandLineRunner initDatas() {
	return args -> {
	    Contact contact = new Contact(null, "DESHIERE", "Stéphane", "stephane.deshiere@viveris.fr");
	    contactDao.save(contact);
	};
    }
}
