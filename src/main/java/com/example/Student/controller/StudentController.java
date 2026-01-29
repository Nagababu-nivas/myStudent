package com.example.Student.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Student.Exception.StudentNotFoundException;
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
	
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student> getStudentId(@PathVariable Long id) throws StudentNotFoundException  {
		Optional<Student> student = service.findByStudentId(id);
		Student s = student.orElseThrow(() -> 
			new StudentNotFoundException()
		);
		return new ResponseEntity<Student> (s, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteStudentById/{id}")
	public ResponseEntity<Student> deleteAccountByAccountId(@PathVariable Long id) throws StudentNotFoundException {
		return new ResponseEntity<Student>(service.deleteStudent(id), HttpStatus.OK);
	}
	
	
	
}
