package com.example.pathfindr.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pathfindr.model.Role;
import com.example.pathfindr.model.Student;
import com.example.pathfindr.repository.RoleRepository;
import com.example.pathfindr.repository.StudentRepository;

@RestController
public class MainController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoleRepository roleRepository;

    // @GetMapping("/login")
    // public ModelAndView getLoginPage() {
    //     return new ModelAndView("login");
    // }

    // @GetMapping("/signUp")
    // public ModelAndView getSignUpPage() {
    //     return new ModelAndView("signUp");
    // }

    @CrossOrigin
    @PostMapping("/data")
    public String getData() {
        return "Hello World";
    }

    // @PostMapping("/signUp")
    // // @CrossOrigin
    // public ResponseEntity<String> addNewUser(@RequestBody Student student) {

    // Role role = roleRepository.findByName("STUDENT").get();
    // student.setRoles(Collections.singletonList(role));
    // studentRepository.save(student);
    // return ResponseEntity.ok("User added successfully");

    // }

    @GetMapping("/signUp")
    public String signUpPage() {
        // Your controller logic here
        return "signUp"; // This should match the template name
    }

    @PostMapping("/signUp")
    public String addNewUser(@RequestBody Student student) {

        student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()));
        Role role = roleRepository.findByName("STUDENT").get();
        student.setRoles(Collections.singletonList(role));
        studentRepository.save(student);
        return "User added successfully";

    }

    // @PostMapping("/signUp")
    // public ResponseEntity<?> createStudent(@RequestBody Student student) {
    // try {
    // // You may want to perform validation or other operations here before saving
    // Student savedStudent = studentRepository.save(student);
    // return ResponseEntity.ok(savedStudent);
    // } catch (Exception e) {
    // return ResponseEntity.badRequest().body("Failed to create the student: " +
    // e.getMessage());
    // }
    // }
}
