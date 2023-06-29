package org.mykola.spilcaSecurityStudy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserJpa {
   @Id
    private int id;
    private String username;
    private String password;
    private String authority;
}
