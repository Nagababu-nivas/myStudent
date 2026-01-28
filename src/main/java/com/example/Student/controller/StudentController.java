package com.example.Student.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Student.entities.Student;
import com.example.Student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/createStudents")
	public ResponseEntity<Student> postAccount(@RequestBody Student account) {
	    return new ResponseEntity<>(service.saveAccount(account), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getAccounts()  {
		return new ResponseEntity<List<Student>> (service.getAllStudents(), HttpStatus.OK);
	}
	
}
