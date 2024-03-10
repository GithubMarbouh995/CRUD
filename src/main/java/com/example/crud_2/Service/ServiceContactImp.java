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
    public boolean addContact(Contact contact) {
        if (contactDao.emailExist(contact.getEmail())) {
            return false;
        }
        else {
            contactDao.saveContact(contact);
            return true;
        }
    }

    @Override
    public boolean updateContact(Contact contact, int id) {
        if (contactDao.emailExist(contact.getEmail())) {
            return false;
        }
        else {
            contactDao.updateContact(contact, id);
            return true;
        }
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
