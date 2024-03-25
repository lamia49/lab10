package com.example.job_seeking_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "title must be not empty")
    @Size(min = 5,message = " title length must be more then 4")
    @Column(columnDefinition ="varchar(10) not null check (length(title) > 4)")
    private String title;
    @NotEmpty(message = "descrbtion must be not empty")
    @Column(columnDefinition = "varchar(200) not null ")
    private String descripstion;
    @NotEmpty(message = "location must be not empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String  location;
    @Positive(message = "salary must be only positive")
    @Column(columnDefinition = "int check(salary>3000)")
    //    @NotNull(message = "slaray must be not empty")
    private Integer salary;
    @DateTimeFormat
    @Column(columnDefinition = "datetime")
    private LocalDateTime postingDate;
}
