///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author JuanArevaloMerchan
// */

import conu.conuwebserver.UserRepository;
import conu.conuwebserver.User;
import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)

@SpringBootTest

public class UserRepositoryTest {

    @Autowired

    private UserRepository userRepository;

    @Before

    public void setUp() throws Exception {

        User user1= new User("Alice", 23);

        User user2= new User("Bob", 38);

        //save user, verify has ID value after save

        assertNull(user1.getId());

        assertNull(user2.getId());//null before save

        this.userRepository.save(user1);

        this.userRepository.save(user2);

        assertNotNull(user1.getId());

        assertNotNull(user2.getId());

    }

    @Test

    public void testFetchData(){

        /*Test data retrieval*/



    }

}