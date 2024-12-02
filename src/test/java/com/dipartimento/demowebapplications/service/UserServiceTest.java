package com.dipartimento.demowebapplications.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {


    private final IUserService service;

    UserServiceTest(IUserService service) {
        this.service = service;
    }



    @Test
    void dependencyTest(){
        assertNotNull(service);
    }

    @Test
    void whenNeedTryToCreateANEwUSer_Then_theUSerWasCreated() {




    }


}
