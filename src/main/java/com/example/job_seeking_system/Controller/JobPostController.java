package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Service.jobPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/job_seeking/post")
public class JobPostController {
    private final jobPostService jobPostService;



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid JobPost jobPost , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        jobPostService.add(jobPost);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
   public  ResponseEntity get(){
        return ResponseEntity.status(200).body(jobPostService.get());
   }


   @PutMapping("/update/{id}")
   public ResponseEntity update(@PathVariable int id , @RequestBody @Valid JobPost jobPost){

        boolean isFound= jobPostService.update(id,jobPost);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("not found ");
   }



   @DeleteMapping("delete/{id}")

   public ResponseEntity delete(@PathVariable int id ){
        boolean isFound= jobPostService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("not found");
   }
}
