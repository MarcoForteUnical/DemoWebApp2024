package com.dipartimento.demowebapplications.config.security;

import com.dipartimento.demowebapplications.model.Utente;
import com.dipartimento.demowebapplications.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UnicalUserDetailsService implements UserDetailsService {

    private final IUserService userService;

    public UnicalUserDetailsService(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<Utente> user = this.userService.getUser(username);

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }



}
