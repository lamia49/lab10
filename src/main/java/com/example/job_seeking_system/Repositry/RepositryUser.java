package com.example.job_seeking_system.Repositry;

import com.example.job_seeking_system.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryUser extends JpaRepository<User,Integer> {
}
