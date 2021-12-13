package com.playground.playground.springboot.webservices.restful.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date birthdate;
}
