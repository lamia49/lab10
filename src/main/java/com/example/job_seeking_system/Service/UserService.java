package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repositry.RepositryUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final RepositryUser repositryUser;


    public void add(User user){
        repositryUser.save(user);
    }

    public List get(){
        return repositryUser.findAll();
    }

    public Boolean update(Integer id,User user){
        User user1=repositryUser.getById(id);
        if(user1==null){
            return false;
        }

        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        return true;
    }

    public Boolean delete(Integer id ){
        User user=repositryUser.getById(id);
        if (user == null) {
            return false;
        }
        repositryUser.delete(user);
        return true;
    }


}
