package com.example.crud_2.Service;
import com.example.crud_2.DAO.ContactDao;
import com.example.crud_2.DAO.ContactDaoImp;
import com.example.crud_2.Model.Contact;
import java.util.List;

public class ServiceContactImp implements ServiceContact {
    private ContactDao contactDao;

    public ServiceContactImp() {
        contactDao = new ContactDaoImp();
    }
    @Override
    public void addContact(Contact contact) {
        contactDao.saveContact(contact);

    }

    @Override
    public void updateContact(Contact contact, int id) {
        contactDao.updateContact(contact, id);

    }

    @Override
    public void deleteContact(int id) {
        contactDao.deleteContact(id);

    }

    @Override
    public List<Contact> showAllContacts() {
        return contactDao.listContact();
    }

    @Override
    public Contact getContact(int id) {
        return contactDao.getContact(id);
    }

    @Override
    public List<Contact> searchContact(String motcle) {return contactDao.searchContact(motcle);}
}
