package com.dipartimento.demowebapplications.persistence.dao.impljdbc;

import com.dipartimento.demowebapplications.model.Piatto;
import com.dipartimento.demowebapplications.model.UserRole;
import com.dipartimento.demowebapplications.model.Utente;
import com.dipartimento.demowebapplications.persistence.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoJDBC  implements UserDao {


    Connection connection;


    public UserDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Utente findByPrimaryKey(String username) {

        String query = "SELECT username, password , role FROM utente WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Utente(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        UserRole.valueOf(resultSet.getString("role"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void save(Utente utente) {


        String query = "INSERT INTO utente (username, password , role) VALUES (?, ? , ?) " ;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, utente.getUsername());
            statement.setString(2, utente.getPassword());
            statement.setString(3, utente.getRole().toString());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
