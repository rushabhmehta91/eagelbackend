package com.mswm.codeathon.demo.persistence.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personid;
    private String lastname;
    private String firstname;
    private String address;
    private String city;
    private String zip;
}
