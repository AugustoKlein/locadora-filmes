package com.locadora.locadorafilmes.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserPrincipal extends User {

    public UserPrincipal(com.locadora.locadorafilmes.model.User user,Set<GrantedAuthority> authorities) {
        super(user.getEmail(),user.getPassword(),authorities);
    }
}
