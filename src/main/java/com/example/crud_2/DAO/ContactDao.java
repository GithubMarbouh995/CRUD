package com.example.crud_2.DAO;

import com.example.crud_2.Model.Contact;

import java.util.List;

public interface ContactDao {
    public void saveContact(Contact contact);
    public void updateContact(Contact contact, int id);
    public void deleteContact(int id);
    public List<Contact> listContact();
    public Contact getContact(int id );
    public List<Contact> searchContact(String motCle);
    public boolean emailExist(String email);
}
