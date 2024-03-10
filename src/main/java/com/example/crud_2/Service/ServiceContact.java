package com.example.crud_2.Service;

import com.example.crud_2.Model.Contact;

import java.util.List;

public interface ServiceContact {
    public boolean addContact(Contact contact);
    public boolean updateContact(Contact contact, int id);
    public void deleteContact(int id);
    public List<Contact> showAllContacts();
    public Contact getContact(int id );
    public List<Contact> searchContact(String motcle);
}