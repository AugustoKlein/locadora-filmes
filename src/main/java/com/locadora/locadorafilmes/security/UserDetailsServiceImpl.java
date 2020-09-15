package com.locadora.locadorafilmes.security;

import com.locadora.locadorafilmes.model.User;
import com.locadora.locadorafilmes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);

       if(user == null){
           throw new UsernameNotFoundException(email);
       }

       return new UserPrincipal(user,checkGrantedAuthority(user.getUserType()));
    }

    private Set<GrantedAuthority> checkGrantedAuthority(User.UserType userType){
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userType.toString()));
        return grantedAuthorities;
    }

}
