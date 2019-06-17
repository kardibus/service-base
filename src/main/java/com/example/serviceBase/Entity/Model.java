package com.example.serviceBase.Entity;

import javax.persistence.*;

@Entity
@Table(name="model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;



}
