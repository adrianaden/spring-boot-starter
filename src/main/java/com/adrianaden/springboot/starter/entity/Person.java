package com.adrianaden.springboot.starter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class Person {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    @Getter
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Setter
    @Getter
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Setter
    @Getter
    @Column(name = "gender")
    private String gender;

    @Getter
    @Column(name = "salutation")
    private String salutation;

    @Getter
    @Column(name = "full_name")
    private String fullName;

    @Setter
    @Getter
    @Column(name = "address")
    private String address;

    @Getter
    @Column(name = "created_date")
    private Timestamp createdDate;

    @Getter
    @Column(name = "update_date")
    private Timestamp updatedDate;

    @PrePersist
    public void prePersist() {
        this.generateFullName();
        this.generateSalutation();
        createdDate = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate() {
        this.generateFullName();
        this.generateSalutation();
        updatedDate = new Timestamp(System.currentTimeMillis());
    }

    private void generateFullName() {
        fullName = firstName + ' ' + lastName;
    }

    private void generateSalutation() {
        if ("M".equals(gender)) {
            salutation = "Mr";
        } else if ("F".equals(gender)) {
            salutation = "Mrs";
        } else {
            salutation = null;
        }
    }
}
