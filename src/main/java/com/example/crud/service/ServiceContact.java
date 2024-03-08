package com.example.crud.service;
import com.example.crud.model.Contact;

import java.util.List;

public interface ServiceContact {
    public void addContact(Contact contact);
    public void updateContact(Contact contact, int id);
    public void deleteContact(int id);
    public List<Contact> showAllContacts();
    public Contact getContact(int id );
    public List<Contact> searchContact(String motcle);
}
