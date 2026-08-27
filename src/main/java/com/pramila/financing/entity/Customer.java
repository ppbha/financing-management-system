package com.pramila.financing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Column(name = "email",unique = true)
    private String email;

    @NotBlank
    private LocalDate dateOfBirth;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String phone;

    @NotBlank
    @Column(unique = true)
    private String governmentId;

}
