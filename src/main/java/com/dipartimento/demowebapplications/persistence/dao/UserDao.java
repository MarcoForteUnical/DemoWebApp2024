package com.dipartimento.demowebapplications.persistence.dao;

import com.dipartimento.demowebapplications.model.Piatto;
import com.dipartimento.demowebapplications.model.Utente;

public interface UserDao {


    public Utente findByPrimaryKey(String username);

    public void save(Utente utente);




}
