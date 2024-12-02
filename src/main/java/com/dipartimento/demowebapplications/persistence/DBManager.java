package com.dipartimento.demowebapplications.persistence;

import com.dipartimento.demowebapplications.model.Utente;
import com.dipartimento.demowebapplications.persistence.dao.PiattoDao;
import com.dipartimento.demowebapplications.persistence.dao.RistoranteDao;
import com.dipartimento.demowebapplications.persistence.dao.UserDao;
import com.dipartimento.demowebapplications.persistence.dao.impljdbc.PiattoDaoJDBC;
import com.dipartimento.demowebapplications.persistence.dao.impljdbc.RistoranteDaoJDBC;
import com.dipartimento.demowebapplications.persistence.dao.impljdbc.UserDaoJDBC;

import java.sql.*;

public class DBManager {
    private static DBManager instance = null;

    private DBManager(){}
    private RistoranteDao ristoranteDao = null;
    private PiattoDao piattoDao = null;
    private UserDao userDao = null;

    public static DBManager getInstance(){
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    Connection con = null;

    public Connection getConnection(){
        if (con == null){
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Unical", "postgres", "123456");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }
/*
    public PiattoDao getPiattoDao(){
        return new PiattoDaoPostgres(getConnection());
    }

    public UtenteDao getUtenteDao(){
        return new UtenteDaoPostgres(getConnection());
    }
*/
    public RistoranteDao getRistoranteDao(){
        if (ristoranteDao == null) {
            ristoranteDao = new RistoranteDaoJDBC(getConnection());
        }
        return  ristoranteDao;
    }

    public PiattoDao getPiattoDao(){
        if (piattoDao == null) {
            piattoDao = new PiattoDaoJDBC(getConnection());
        }
        return  piattoDao;
    }


    public UserDao getUserDao(){
        if (userDao == null) {
            userDao = new UserDaoJDBC(getConnection());
        }
        return  userDao;
    }



    public static void main(String[] args) {
        Connection con = DBManager.getInstance().getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from utenti");
            if (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
