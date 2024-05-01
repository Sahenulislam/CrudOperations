package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @PostMapping("/AddStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
    
    
    @PostMapping("/AddStudents")
    public List<Student> addStudents(@RequestBody List<Student>student) {
        return studentService.saveAll(student);
    }
    
    
    @GetMapping("/FindStudents")
    public List<Student>FindAllStudents(){
        return studentService.findAll();
    }
    
    
    @GetMapping("/FindStudent/{id}")
    public Student FindStudentById(@PathVariable  int id) {
        return studentService.findById(id);
    }
    

    @GetMapping("/FindStudentsPagination/{page}/{pagesize}")
    public Page<Student> FindStudentPagination(@PathVariable int page, @PathVariable int pagesize)
    {
        return studentService.getStudentPagination(page,pagesize);
    }

    @DeleteMapping("/DeleteStudent/{id}")
    public String DeleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
        return "product removed || "+id; 
    }
    
    
    @PutMapping("/UpdateStudent/{id}")
    public Student UpdateStudent(@PathVariable int id, @RequestBody Student student)
    {
        return studentService.update(id,student);
    }


    @GetMapping("/FindAllStudentBySection/{Section}")
    public  List<Student> findAllStudentBySection(@PathVariable String Section)
    {
        return studentService.findAllBySection(Section);
    }


    @GetMapping("/FindAllStudentBySection/{section}/{page}/{pagesize}")
    public  Page<Student> findAllStudentBySectionPaging(@PathVariable String section,
                                                        @PathVariable int page,
                                                        @PathVariable int pagesize)
    {
            return studentService.findAllBySectionPaging(section,page,pagesize);

    }

    @GetMapping("/FindAnwarCloudeNodes")
    public String FindAnwarCloudeNodes() {
        String uri = "http://172.17.17.14:8080/goapi/anwarcloud/nodes";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}