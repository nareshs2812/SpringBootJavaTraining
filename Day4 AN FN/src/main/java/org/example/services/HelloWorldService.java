package org.example.services;

import org.example.models.Students;
import org.example.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldService {

    @Autowired

    private StudentRepository studentRepo;
    public List<Students> getMethod() {
        return studentRepo.findAll();
    }


    public List<Students> postMethod(Students newStudent) {
        studentRepo.save(newStudent);
        return studentRepo.findAll(); // return updated list
    }


    public String putMethod(int id, Students updatedStudent) {
        Students existing = studentRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setCourse(updatedStudent.getCourse());
            studentRepo.save(existing);
            return "Student with ID " + id + " updated successfully.";
        }
        return "Student with ID " + id + " not found.";
    }


    public String deleteMethod(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return "Student with ID " + id + " deleted successfully.";
        }
        return "Student with ID " + id + " not found.";
    }
}
