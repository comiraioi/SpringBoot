package com.example.Project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="univ")
@Setter
@Getter
@ToString
public class Univ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userno;
    private String identity;
    private String userid;
    private String userpw;
    private String username;
    private String email;
    private String major;
    private Integer grade;
    private Integer credit;
}
