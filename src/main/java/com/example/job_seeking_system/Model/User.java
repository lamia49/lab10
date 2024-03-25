package com.example.job_seeking_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    @NotEmpty(message = "name must be not empty")
    @Size(min = 5,message = "length name must be more then 4")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only characters (no numbers)")
    @Column(columnDefinition = "varchar(15) not null check (length(name) > 4) ")
    private String name;
    @Email(message = "email must be formed in email form")
    @NotEmpty(message = "email must be mot empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "password must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private  String password;
    @Digits(integer = 3, fraction = 0, message = "age must be a number")
    @Min(value = 22, message = "age must be more than 21")
    @Column(columnDefinition = "int check(age > 21)")
    private Integer age;
    @NotEmpty(message = "role must be not empty")
    @Pattern(regexp ="^(JOB_SEEKER|EMPLOYER)$",message = "role must be EMPLOYER or EMPLOYER")
    @Column(columnDefinition = "varchar(20) not null check(role='EMPLOYER' or role='JOB_SEEKER')")
    private String role;


}
