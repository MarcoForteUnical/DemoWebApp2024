package com.dipartimento.demowebapplications.config.security;

import com.dipartimento.demowebapplications.model.UserRole;
import com.dipartimento.demowebapplications.model.Utente;
import com.dipartimento.demowebapplications.service.IUserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@Service
public class VerifyGoogleTokenService {

    private final IUserService userService;

    public VerifyGoogleTokenService(IUserService userService) {
        this.userService = userService;
    }

    public void verifyTokenAndSpawnSession(String token){

        Map<String, Object> stringObjectMap = JwtDecoder.decodeJWT(token);
        Utente userInfo = getUserInfo(stringObjectMap);

        Optional<Utente> user = this.userService.getUser(userInfo.getUsername());
        if(user.isPresent()){
            createSession(user.get());
        }else{
            Utente user1 = this.userService.createUser(userInfo.getUsername(), userInfo.getPassword(), userInfo.getRole());
            createSession(user1);
        }

    }

    private void createSession(Utente utente) {

        // Crea il token di autenticazione
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(utente, null, utente.getAuthorities());

        // Imposta l'autenticazione nel SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("Sessione creata per l'utente: " );

    }

    private Utente getUserInfo(Map<String, Object> stringObjectMap) {

        String username= (String) stringObjectMap.get("email");
        String password= UUID.randomUUID().toString();

        return new Utente(
                username,
                password,
                UserRole.ROLE_USER
        );
    }


}
