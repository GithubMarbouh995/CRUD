package com.example.crud_2.Controller;

import com.example.crud_2.Model.Contact;
import com.example.crud_2.Controller.*;

import java.util.ArrayList;
import java.util.List;

public class PaginationController {
    private List<Contact> Contacts;
    private int rowsPerPage =5 ;
    private int currentPage=1;

    public void setContacts(List<Contact> contacts) {
        Contacts = contacts;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage >= 1) {
            this.currentPage = currentPage;
        }
    }

    public List<Contact> getContacts() {
        ContactController contactController = new ContactController();
        Contacts = contactController.getAllContacts();
        if (Contacts != null) {
            System.out.println(Contacts.size());
            int startIndex = (currentPage - 1) * rowsPerPage;
            int endIndex = Math.min(startIndex + rowsPerPage, Contacts.size());
            return Contacts.subList(startIndex, endIndex);
        }
        else {
            Contacts = new ArrayList<>();
            return Contacts;
        }
    }


    public String nextPage() {
        int totalPages = getTotalPages();
        if (currentPage < totalPages) {
            currentPage++;
        }
        return "index";
    }

    public String previousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
        return "index";
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) Contacts.size() / rowsPerPage);
    }
}
