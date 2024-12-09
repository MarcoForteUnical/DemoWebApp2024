package com.dipartimento.demowebapplications.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

//
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;

//https://developers.google.com/identity/gsi/web/guides/verify-google-id-token?hl=it

@RestController
@RequestMapping("/api/open/google-login")
public class GoogleController {



    @PostMapping
    public ResponseEntity<?> verifyGoogleToken(@RequestBody GoogleTokenRequest request) {

        System.out.println(request);

        System.out.println(request.token);

        return ResponseEntity.ok().build();

    }

    // Classe di richiesta per il token JWT
    public static class GoogleTokenRequest {
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

}
