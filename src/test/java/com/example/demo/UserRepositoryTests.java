package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	 @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private StudentRepository repo;
	    
	    @org.junit.jupiter.api.Test
	    public void testCreateUser() {
	        Student student = new Student();
	        Student.setName("Anantkumar");
	        Student.setLastName("Kumar");
	        Student.setCourse("MBA");
	       
	         
	       Student savedUser = repo.save(student);
	         
	        Student existUser = entityManager.find(Student.class, savedUser.getId());
	         
	        assertThat(student.getLastName()).isEqualTo(existUser.getCourse());
	         
	    }
	    
}
