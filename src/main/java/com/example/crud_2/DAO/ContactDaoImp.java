package com.example.crud_2.DAO;

import com.example.crud_2.Model.Contact;
import com.example.crud_2.util.ConnexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImp implements ContactDao {
    @Override
    public void saveContact(Contact contact) {
        Connection con = ConnexionDB.getConnection();
        if (con == null) {
            return;
        }
                    String sql = "INSERT INTO contacts (name, email, phone, type) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                        preparedStatement.setString(1, contact.getName());
                        preparedStatement.setString(2, contact.getEmail());
                        preparedStatement.setString(3, contact.getPhone());
                        preparedStatement.setString(4, contact.getType());
                        preparedStatement.executeUpdate();
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

    @Override
    public void updateContact(Contact contact, int id) {
        Connection con = ConnexionDB.getConnection();
        if (con == null) {
            return;
        }
        String sql = "UPDATE contacts SET name = ?, email = ?,phone = ?,type = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                        preparedStatement.setString(1, contact.getName());
                        preparedStatement.setString(2, contact.getEmail());
                        preparedStatement.setString(3, contact.getPhone());
                        preparedStatement.setString(4, contact.getType());
                        preparedStatement.setInt(5, id);
                        preparedStatement.execute();
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
    }


    @Override
    public void deleteContact(int id) {
        Connection con = ConnexionDB.getConnection();
        if (con == null) {
            return;
        }
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Contact> listContact() {
        Connection con = ConnexionDB.getConnection();
        if (con == null) {
            return null;
        }
        String sql = "SELECT * FROM contacts";
        List<Contact> contacts = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.execute();
            while (preparedStatement.getResultSet().next()) {
                Contact contact = new Contact();
                contact.setId(preparedStatement.getResultSet().getInt("id"));
                contact.setName(preparedStatement.getResultSet().getString("name"));
                contact.setEmail(preparedStatement.getResultSet().getString("email"));
                contact.setPhone(preparedStatement.getResultSet().getString("phone"));
                contact.setType(preparedStatement.getResultSet().getString("type"));
                if (contacts == null) {
                    contacts = new ArrayList<>();
                }
                contacts.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public Contact getContact(int id) {
        Connection con = ConnexionDB.getConnection();
        if (con == null) {
            return null;
        }
        String sql = "SELECT * FROM contacts WHERE id = ?";
        Contact contact = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            while (preparedStatement.getResultSet().next()) {
                contact = new Contact();
                contact.setId(preparedStatement.getResultSet().getInt("id"));
                contact.setName(preparedStatement.getResultSet().getString("name"));
                contact.setEmail(preparedStatement.getResultSet().getString("email"));
                contact.setPhone(preparedStatement.getResultSet().getString("phone"));
                contact.setType(preparedStatement.getResultSet().getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public List<Contact> searchContact(String motCle) {
        Connection connection = ConnexionDB.getConnection();
        String sql = "SELECT * FROM contacts WHERE name=? or email=? or phone=? or type=?";
        List<Contact> contacts = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, motCle);
            preparedStatement.setString(2, motCle);
            preparedStatement.setString(3, motCle);
            preparedStatement.setString(4, motCle);
            preparedStatement.execute();
            while (preparedStatement.getResultSet().next()) {
                Contact contact = new Contact();
                contact.setId(preparedStatement.getResultSet().getInt("id"));
                contact.setName(preparedStatement.getResultSet().getString("name"));
                contact.setEmail(preparedStatement.getResultSet().getString("email"));
                contact.setPhone(preparedStatement.getResultSet().getString("phone"));
                contact.setType(preparedStatement.getResultSet().getString("type"));
                if (contacts == null) {
                    contacts = new ArrayList<>();
                }
                contacts.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean emailExist(String email) {
        Connection con = ConnexionDB.getConnection();
        if (con == null) {
            return false;
        }
        String test = "SELECT count(*) FROM contacts WHERE email = ?";
        try (PreparedStatement test_email = con.prepareStatement(test)) {
            test_email.setString(1, email);
            test_email.execute();
            if (test_email.getResultSet().next()) {
                if (test_email.getResultSet().getInt(1) > 0) {
                    return true;
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
