package com.dipartimento.demowebapplications.service;


import com.dipartimento.demowebapplications.model.UserRole;
import com.dipartimento.demowebapplications.model.Utente;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IUserService {

    Utente createUser(String username, String password, UserRole role);


    Optional<Utente> getUser(String username);



}
