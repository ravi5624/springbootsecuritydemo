package models;

import jakarta.persistence.*;

@Table(name = "user")
public class PortalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    public String role;

    @Column(name = "enabled")
    public String enabled;



}
