package com.dipartimento.demowebapplications.persistence.dao.impljdbc;

import com.dipartimento.demowebapplications.model.Piatto;
import com.dipartimento.demowebapplications.model.Ristorante;
import com.dipartimento.demowebapplications.persistence.DBManager;
import com.dipartimento.demowebapplications.persistence.dao.PiattoDao;
import com.dipartimento.demowebapplications.persistence.dao.RistoranteDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PiattoDaoJDBC implements PiattoDao {
    Connection conn;

    public PiattoDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Piatto> findAll() {
        List<Piatto> piatti = new ArrayList<Piatto>();
        String query = "select * from piatto";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Piatto piatto = new Piatto();

                piatto.setNome(rs.getString("nome"));
                piatto.setIngredienti(rs.getString("ingredienti"));

                RistoranteDao ristoranteDao = DBManager.getInstance().getRistoranteDao();
                String key = rs.getString("idristorante");
                Ristorante ristorante = ristoranteDao.findByPrimaryKey(key);
                piatto.setRistorante(ristorante);

                piatti.add(piatto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return piatti;
    }

    @Override
    public Piatto findByPrimaryKey(String nome) {
        return null;
    }

    @Override
    public void save(Piatto piatto) {

    }

    @Override
    public void delete(Piatto piatto) {

    }

    public static void main(String[] args) {
        PiattoDao piattoDao = DBManager.getInstance().getPiattoDao();
        List<Piatto> piatti = piattoDao.findAll();
        for (Piatto piatto : piatti) {
            System.out.println(piatto.getNome());
            System.out.println(piatto.getIngredienti());

        }
    }
}
