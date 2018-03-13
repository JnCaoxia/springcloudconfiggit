package com.caox.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author caox
 * @version 1.0.0
 *
 */
@Setter
@Getter
@ToString
public class User {

    private Long id;
    private String name;
    private Integer age;
}
