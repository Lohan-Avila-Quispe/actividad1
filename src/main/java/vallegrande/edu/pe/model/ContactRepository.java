package vallegrande.edu.pe.model;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para el repositorio de contactos.
 */
public interface ContactRepository {
<<<<<<< HEAD
    Contact save (Contact contact);
    Optional <Contact> findById(String id);
    List<Contact> findAll();
    boolean delete(String id);
    boolean deleteById(String id);
=======
 Contact save(Contact contact);
 Optional<Contact> findById(String id);
 List<Contact> findAll();
 boolean deleteById(String id);
>>>>>>> 26ff65823feccc654001c7e7531c693fdcf683cc
}