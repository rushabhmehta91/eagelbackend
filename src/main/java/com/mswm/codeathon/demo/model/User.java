package com.mswm.codeathon.demo.model;


import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.lang.model.element.Name;

@Entry(
        base = "ou=users",
        objectClasses = {"person", "inetOrgPerson", "top"})
@Data
public class User {
    @Id
    private Name id;

    private @Attribute(name = "cn")
    String username;

}
