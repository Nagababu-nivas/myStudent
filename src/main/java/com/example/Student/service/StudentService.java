package com.example.Student.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Student.entities.Student;
import com.example.Student.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	public List<Student> getAllStudents()  {
		List<Student> allStudents = repo.findAll();
		if (allStudents.isEmpty() || allStudents == null)
			return null;
		else
			return allStudents;
	}
	
	public Student saveAccount(Student student) {
	    Student s = repo.save(student);
		return s;
	}

}
