package com.adrianaden.springboot.starter.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@ToString
public class Person {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Setter
    @Getter
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
    private LocalDateTime createdDate;

    @Getter
    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
