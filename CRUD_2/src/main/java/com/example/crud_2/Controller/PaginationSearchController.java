package com.example.crud_2.Controller;

import com.example.crud_2.Model.Contact;
import com.example.crud_2.Service.ServiceContact;
import com.example.crud_2.Service.ServiceContactImp;

import java.util.List;

public class PaginationSearchController {
    private ServiceContact serviceContact;
    private List<Contact> SearchContacts;
    private int rowsPerPage =5 ;
    private int currentPage=1;
    private String search;
    public PaginationSearchController() {
        serviceContact = new ServiceContactImp();
    }

    public void setSearchContacts(List<Contact> contacts) {
        SearchContacts = contacts;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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

    public List<Contact> getSearchContacts() {
        SearchContacts=searchContact();
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage,SearchContacts.size());
        return SearchContacts.subList(startIndex, endIndex);
    }


    public String nextPage() {
        int totalPages = getTotalPages();
        if (currentPage < totalPages) {
            currentPage++;
        }
        return "recherche";
    }
    public String previousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
        return "recherche";
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) SearchContacts.size() / rowsPerPage);
    }
    public List<Contact> searchContact() {
        System.out.println(this.search);
        return serviceContact.searchContact(this.search);
    }
}
