package com.helloworldgroup.helloworld.sercurityconfig;

import com.helloworldgroup.helloworld.service.EmployeeService;
import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Employee emp =  employeeService.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User with email=%s was not found", username)));
        Set<GrantedAuthority> authorities = Collections.emptySet();
//        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return new org.springframework.security.core.userdetails.User(
                emp.getEmail(),
                emp.getPassword(),
                authorities
        );
    }
}
