package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.JopApplication;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repositry.RepositryJobApp;
import com.example.job_seeking_system.Repositry.RepositryJobPost;
import com.example.job_seeking_system.Repositry.RepositryUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobAppService {
    public final RepositryJobApp repositryJobApp;
    public final RepositryJobPost repositryJobPost;
    public final RepositryUser repositryUser;
    public Boolean add(int idUser,int idJopPost,JopApplication jopApplication){
     if(repositryUser.findById(idUser)!=null&&repositryJobPost.findById(idJopPost)!=null){
         repositryJobApp.save(jopApplication);
         return true;
     }
        return false;
    }
    public List get(){
        return repositryJobApp.findAll();
    }

    public Boolean delete(int idJobApp){
        JopApplication jopApplication1= repositryJobApp.getById(idJobApp);
        if(jopApplication1==null){
            return false;
        }
        repositryJobApp.delete(jopApplication1);
        return true;
    }


}
