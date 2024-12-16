package com.dipartimento.demowebapplications.service;


import com.dipartimento.demowebapplications.model.UserRole;
import com.dipartimento.demowebapplications.model.Utente;
import com.dipartimento.demowebapplications.persistence.DBManager;
import com.dipartimento.demowebapplications.persistence.dao.UserDao;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
 class UserService implements  IUserService{

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    UserService(PasswordEncoder passwordEncoder) {
        this.userDao = DBManager.getInstance().getUserDao();
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Utente createUser(String username, String password, UserRole role) {

        //TODO checks:
        //  fields are not null ,
        //  password complex
        // username not already used


        this.userDao.save(new Utente(
                username,
                passwordEncoder.encode(password),
                role
        ));

        return this.getUser(username).get();

    }

    @Override
    public Optional<Utente> getUser(String username) {

        Utente byPrimaryKey = this.userDao.findByPrimaryKey(username);

        if(byPrimaryKey == null) {
            return Optional.empty();
        }

        return Optional.of(byPrimaryKey);
    }
}
