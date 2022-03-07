//package com.sheryians.major.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import java.util.List;
//
//
//@Data
//@Table(name = "users")
//@Entity
//public class User{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @NotEmpty
//    @Column(nullable = false)
//    private String firstName;
//
//    private String lastName;
//
//    @Column(nullable = false,unique = true)
//    @NotEmpty
//    @Email(message = "{errors.invalid_email}")
//    private String email;
//    @NotEmpty
//    @Column(nullable = false)
//    private String password;
//@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
//    private List<Role> roles;
//
//}
