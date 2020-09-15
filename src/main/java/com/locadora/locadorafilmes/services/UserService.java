package com.locadora.locadorafilmes.services;

import com.locadora.locadorafilmes.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User createUser(User customer);
}
