package org.example.services;

import org.example.models.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Students> students = new ArrayList<>(
            Arrays.asList(
                    new Students(1, "Naresh", "CSE"),
                    new Students(2, "Surya", "BME"))
    );

    public List<Students> getMethod() {
        return students;
    }

    public List<Students> postMethod(Students newStudent) {
        students.add(newStudent);
        return students;
    }

    public String putMethod(int id, Students updatedStudent) {
        for (Students s : students) {
            if (s.getStudentId() == id) {
                s.setName(updatedStudent.getName());
                s.setCourse(updatedStudent.getCourse());
                return "Student with ID " + id + " was updated.";
            }
        }
        return "Student with ID " + id + " not found to update";
    }

    public String deleteMethod(int id) {
        boolean removed = students.removeIf(s -> s.getStudentId() == id);
        if (removed) {
            return "Student with ID " + id + " was removed.";
        } else {
            return "Student with ID " + id + "was not found to delete";
        }
    }
}
