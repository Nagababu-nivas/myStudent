package com.example.Student.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Student.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

}
