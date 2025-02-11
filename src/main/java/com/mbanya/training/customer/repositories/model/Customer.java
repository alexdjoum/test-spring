package com.mbanya.training.customer.repositories.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

import com.mbanya.training.customer.repositories.Gender;
import com.mbanya.training.customer.repositories.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date birthday;
    
    @Enumerated(EnumType.STRING)
    private Type type;

    private String description;
    private String countryIdentityNumber;
    private String countryIdentityType;
    private String phoneNumber;
    private String country;
    private String profession;
    private String city;
    private String region;
    private String street;
    private String address;
}
