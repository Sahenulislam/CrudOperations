package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
 
	@Autowired
	StudentRepository studentRepository;
//	StudentPagableRepository studentPagableRepository;

	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	
	public List<Student> saveAll(List<Student>student) {
		return studentRepository.saveAll(student);
	}
	
	
	public List<Student> findAll(){
		
		return studentRepository.findAll();
    }
	
	
	public Student findById(int id) {
		return studentRepository.findById(id).orElse(null);
	}


	public List<Student> findAllBySection(String Section){
		return studentRepository.findAllBySection(Section);
	}

	public Page<Student> findAllBySectionPaging(String section, int page, int pagesize) {
		return studentRepository.findAllBySection(section,PageRequest.of(page,pagesize));
	}

	public Page<Student> getStudentPagination(int page, int pagesize)
	{
		Pageable sortedByName = PageRequest.of(page,pagesize);
		return studentRepository.findAll(sortedByName);
	}
	
	public String deleteById(int id) {
		studentRepository.deleteById(id);
		return "product removed || "+id; 
	}

	// not needed
	public Student update(int id, Student pStudent) {
	    // Find the existing student by ID
	    Optional<Student> optionalExistingStudent = studentRepository.findById(id);


	    // Check if the student exists in the database
	    if (optionalExistingStudent.isPresent()) {
	        Student existingStudent = optionalExistingStudent.get();

	        // Update the existing student's data with the new data
	        existingStudent.setStudentName(pStudent.getStudentName());
	        existingStudent.setStudentIntake(pStudent.getStudentIntake());
	        existingStudent.setStudentSection(pStudent.getStudentSection());

	        // Save the updated student record in the database
	        return studentRepository.save(existingStudent); ////////////save alada
	    } else {
	        // Handle the case where the student with the given ID does not exist
	        // You might throw an exception, return null, or handle it in some other way
	        return null;
	    }
	}


}
