package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Repositry.RepositryJobPost;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class jobPostService {
    private final RepositryJobPost repositryJobPost;
    public void add(JobPost jobPost){
        repositryJobPost.save(jobPost);
    }

    public List get(){
        return repositryJobPost.findAll();
    }

    public Boolean update(Integer id,JobPost jobPost){
        JobPost jobPost1=repositryJobPost.getById(id);
        if(jobPost1==null){
            return false;
        }

       jobPost1.setTitle(jobPost.getTitle());
        jobPost1.setDescripstion(jobPost.getDescripstion());
        jobPost1.setPostingDate(jobPost.getPostingDate());
        jobPost1.setSalary(jobPost.getSalary());
        jobPost1.setLocation(jobPost.getLocation());
        return true;
    }

    public Boolean delete(Integer id ){
        JobPost jobPost=repositryJobPost.getById(id);
        if (jobPost == null) {
            return false;
        }
        repositryJobPost.delete(jobPost);
        return true;
    }


}
