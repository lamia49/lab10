package com.example.job_seeking_system.Repositry;

import com.example.job_seeking_system.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryJobPost extends JpaRepository<JobPost,Integer> {
}
