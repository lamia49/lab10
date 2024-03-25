package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Model.JopApplication;
import com.example.job_seeking_system.Service.JobAppService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/job_seeking/jop_app")
public class jobAppController {
    private final JobAppService jobAppService;


    @PostMapping("/add/{userId}/{idJobPost}")
    public ResponseEntity add(@PathVariable int userId,@PathVariable int idJobPost, @RequestBody @Valid JopApplication jopApplication , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        jobAppService.add(userId,idJobPost,jopApplication);
        return ResponseEntity.status(200).body("added");
    }

    @GetMapping("/get")
    public  ResponseEntity get(){
        return ResponseEntity.status(200).body(jobAppService.get());
    }

    @DeleteMapping("delete/{id}")

    public ResponseEntity delete(@PathVariable int id ){
        boolean isFound= jobAppService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("not found");
    }

}
