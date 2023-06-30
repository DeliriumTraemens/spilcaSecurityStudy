package org.mykola.spilcaSecurityStudy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class JpaUser {
   @Id
    private int id;
    private String username;
    private String password;
    private String authority;
}
