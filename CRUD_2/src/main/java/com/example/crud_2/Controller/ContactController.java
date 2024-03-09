package com.example.crud_2.Controller;
import com.example.crud_2.Model.Contact;
import com.example.crud_2.Service.ServiceContact;
import com.example.crud_2.Service.ServiceContactImp;
import jakarta.annotation.ManagedBean;
import jakarta.faces.component.html.HtmlDoctype;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;

import java.util.List;
import java.util.Locale;

public class ContactController {
        private final ServiceContact serviceContact ;
        private String search ;
        private boolean isDisabled;
        private int editingId = -1;
        public ContactController() {
            serviceContact = new ServiceContactImp();
            isDisabled = true;

        }

        public boolean isDisabled() {
            return isDisabled;
        }

        public void setDisabled(boolean disabled) {
            this.isDisabled = disabled;
        }
        public int getEditingId() {
            return editingId;
        }
        public void setEditingId(int editingId) {
            this.editingId = editingId;
        }


    public String getSearch() {
            return search;
        }
        public void setSearch(String search) {
            this.search = search;
        }
        public String AddContact(AddController bean) {
            Contact contact = new Contact();
            contact.setName(bean.getName());
            contact.setEmail(bean.getEmail());
            contact.setPhone(bean.getPhone());
            contact.setType(bean.getType());
            serviceContact.addContact(contact);
            return "index.xhtml";
        }
        public void UpdateContact(EditController bean) {
            Contact contact = new Contact();
            contact.setName(bean.getName());
            contact.setEmail(bean.getEmail());
            contact.setPhone(bean.getPhone());
            contact.setType(bean.getType());
            System.out.println("from updateLive contact.getName() = " + contact.getName());
            System.out.println("from updateLive contact.getId() = " + editingId);
            serviceContact.updateContact(contact,editingId);
            System.out.println("from UpdateContact " );
            editingId = -1;
        }
        public void deleteContact(int id) {
            serviceContact.deleteContact(id);
        }
        public void getContact(int id) {
            serviceContact.getContact(id);
        }
        public List<Contact> getAllContacts () {
            return serviceContact.showAllContacts();
        }
        public List<Contact> searchContact() {
            return serviceContact.searchContact(this.search);}


        public void UpdateIsDisabled(int id ) {
            Contact contact = serviceContact.getContact(id);
            if (contact.getId() == id) {
                System.out.println("from updateLive if contact.getId() = " + contact.getId());
                editingId = id;
            }
        }

}
