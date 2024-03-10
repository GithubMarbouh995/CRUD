package com.example.crud_2.Controller;

import com.example.crud_2.Model.Contact;
import com.example.crud_2.Service.ServiceContact;
import com.example.crud_2.Service.ServiceContactImp;

public class EditController {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String type;
    private String verification="false";

    private int editingId = -1;
    private ServiceContact serviceContact;

    public EditController() {
        serviceContact = new ServiceContactImp();
    }

    public EditController(String name, String email, String phone, String type) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }
    public EditController(int id, String name, String email, String phone, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    public int getEditingId() {
        return editingId;
    }

    public void setEditingId(int editingId) {
        this.editingId = editingId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public void UpdateIsDisabled(int id ) {
        Contact contact = serviceContact.getContact(id);
        if (contact.getId() == id) {
            System.out.println("from updateLive if contact.getId() = " + contact.getId());

            setName(contact.getName());
            setEmail(contact.getEmail());
            setPhone(contact.getPhone());
            setType(contact.getType());

        }
        editingId = id;
    }
    public void UpdateContact(EditController bean) {
        Contact contact = new Contact();
        contact.setName(bean.getName());
        contact.setEmail(bean.getEmail());
        contact.setPhone(bean.getPhone());
        contact.setType(bean.getType());
        System.out.println("from updateLive contact.getName() = " + contact.getName());
        System.out.println("from updateLive contact.getId() = " + editingId);
        if (!serviceContact.updateContact(contact, editingId)) {
            this.verification= "true";
        }
        else {
            System.out.println("from UpdateContact ");
            editingId = -1;
            this.verification= "false";
        }
        System.out.println("from UpdateContact verification = " + verification);
    }

}