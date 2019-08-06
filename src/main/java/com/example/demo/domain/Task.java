package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
}
