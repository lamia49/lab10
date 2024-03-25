package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job_seeking/user")
@AllArgsConstructor
public class UserController {
private  final UserService userService;



@PostMapping("/add")
public ResponseEntity add(@RequestBody @Valid User user , Errors error){
    if(error.hasErrors()){
        String massege= error.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(massege);
    }
    userService.add(user);
    return ResponseEntity.status(200).body("added");
}


@GetMapping("/get")
public ResponseEntity get(){
    return ResponseEntity.status(200).body(userService.get());
}

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id ,@RequestBody @Valid User user,Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isFound= userService.update(id,user);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("not found");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isFound= userService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("not found");
    }
}
