package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contact;
import vallegrande.edu.pe.model.ContactRepository;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que maneja la lógica entre la vista y el modelo.
 */
public class ContactController {
    private final ContactRepository repo;

    public ContactController(ContactRepository repo) {
        this.repo = repo;
    }

    // Crear un nuevo contacto y guardarlo
    public Contact create(String id, String name, String email, String phone) {
        Contact c = new Contact(id, name, email, phone);
        return repo.save(c);
    }

    // Buscar contacto por ID
    public Optional<Contact> get(String id) {
        return repo.findById(id);
    }

    // Listar todos los contactos
    public List<Contact> list() {
        return repo.findAll();
    }

    // Eliminar contacto por ID
    public boolean delete(String id) {
<<<<<<< HEAD
        return repo.delete(id);
    }

    public void addContact(String valueOf, String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addContact'");
    }

    public Contact[] getContacts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContacts'");
=======
        return repo.deleteById(id);
>>>>>>> 26ff65823feccc654001c7e7531c693fdcf683cc
    }
}