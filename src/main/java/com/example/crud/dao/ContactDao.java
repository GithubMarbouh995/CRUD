package com.example.crud.dao;
import com.example.crud.model.Contact;

import java.util.List;

public interface ContactDao {
    public void saveContact(Contact contact);
    public void updateContact(Contact contact, int id);
    public void deleteContact(int id);
    public List<Contact> listContact();
    public Contact getContact(int id );
    public List<Contact> searchContact(String motCle);

}
