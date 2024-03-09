package com.example.crud_2.DAO;

import com.example.crud_2.Model.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection con;
    private PreparedStatement statementUpdate;

    public List<Client> listerArticles(String recherche) {
        List<Client> liste = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD", "root", "03112002");
            statementUpdate = con.prepareStatement("SELECT * FROM Client WHERE nom=? or email=? or telephone=?");
            statementUpdate.setString(1,recherche);
            ResultSet resultSet = statementUpdate.executeQuery();
            if (resultSet.next()) {
                Client client=new Client();
                client.setName(resultSet.getString(1));
                client.setEmail(resultSet.getString(2));
                client.setTelephone(resultSet.getString(3));
                client.setType(resultSet.getString(4));
                liste.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
}
