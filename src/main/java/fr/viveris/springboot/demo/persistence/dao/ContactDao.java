package fr.viveris.springboot.demo.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.viveris.springboot.demo.persistence.model.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {

    List<Contact> findAllByNom(String nom);

    @Query("select c from #{#entityName} c where c.nom like concat(:nom, '%')")
    List<Contact> searchByNom(@Param("nom") String nom);
}
