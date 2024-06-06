package com.jwt.example.service;

import com.jwt.example.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store=new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Krishan","kkmail"));
        store.add(new User(UUID.randomUUID().toString(),"Kris","gmail"));
    }

    public List<User> getUsers() {
        return store;
    }
}
