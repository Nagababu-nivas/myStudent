package com.example.Student.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Student.Exception.StudentNotFoundException;
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
	
	public Optional<Student> findByStudentId(Long accountId) throws StudentNotFoundException {
		Optional<Student> account = repo.findById(accountId);
		if (account == null) {
			throw new StudentNotFoundException("Student is Not found Buddy!");
		} else {
			return account;
		}
	}
	
	public Student deleteStudent(Long accountId) throws StudentNotFoundException {
		Student account = repo.findById(accountId)
				.orElseThrow(() -> new StudentNotFoundException ("Student not found with " + accountId));
		repo.delete(account);
		return account;
	}
	
	
	

}
