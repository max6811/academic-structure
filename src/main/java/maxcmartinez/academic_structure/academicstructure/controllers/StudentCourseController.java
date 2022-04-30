package maxcmartinez.academic_structure.academicstructure.controllers;

import maxcmartinez.academic_structure.academicstructure.models.Course;
import maxcmartinez.academic_structure.academicstructure.models.Student;
import maxcmartinez.academic_structure.academicstructure.repositories.CourseRepository;
import maxcmartinez.academic_structure.academicstructure.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentCourseController {
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public CourseRepository courseRepository;

    @PostMapping
    public void createDate(){
        Course course1 = new Course("Course1");
        Course course2 = new Course("Course2");
        Course course3 = new Course("Course3");

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        Student student1 = new Student("Max");
        List<Course> courses1 = new ArrayList<>();
        courses1.add(course1);
        courses1.add(course2);
        courses1.add(course3);
        student1.setCourseList(courses1);
        studentRepository.save(student1);

        Student student2 = new Student("Juan");
        List<Course> courses2 = new ArrayList<>();
        courses2.add(course1);
        student2.setCourseList(courses2);
        studentRepository.save(student2);

        Student student3 = new Student("Carla");
        List<Course> courses3 = new ArrayList<>();
        courses3.add(course2);
        student3.setCourseList(courses3);
        studentRepository.save(student3);

    }

    @GetMapping
    public List<Student> getDate(){
        return studentRepository.findAll();
    }

}
