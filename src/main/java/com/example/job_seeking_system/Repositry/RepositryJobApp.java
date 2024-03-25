package com.example.job_seeking_system.Repositry;

import com.example.job_seeking_system.Model.JopApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryJobApp extends JpaRepository<JopApplication,Integer> {
}
