package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_user")
@Data
@NoArgsConstructor
public class User {
	
	@Id
    private String username;
	
    private String password;
    private String active;
    private String roles;

}
