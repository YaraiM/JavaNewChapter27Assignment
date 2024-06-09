package raisetech.student.management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.student.management.controller.converter.StudentConverter;
import raisetech.student.management.model.data.Student;
import raisetech.student.management.model.data.StudentCourse;
import raisetech.student.management.model.domain.StudentDetail;
import raisetech.student.management.model.services.StudentService;

@Controller
public class StudentController {

  private final StudentService service;
  private final StudentConverter converter;
  private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentCourse> studentsCourses = service.searchStudentsCourseList();
    List<StudentDetail> studentsDetails = converter.convertStudentDetails(students,
        studentsCourses);

    // ビュー（studentListテンプレート）の${studentList}にstudentsDetailsを渡す。
    model.addAttribute("studentList", studentsDetails);
    return "studentList"; // studentList.htmlを指す。
  }

  @GetMapping("/studentCourseList")
  public String getStudentCourseList(Model model) {
    List<StudentCourse> studentsCourses = service.searchStudentsCourseList();

    model.addAttribute("studentCourseList", studentsCourses);
    return "studentCourseList"; // studentCourseList.htmlを指す。
  }
}
