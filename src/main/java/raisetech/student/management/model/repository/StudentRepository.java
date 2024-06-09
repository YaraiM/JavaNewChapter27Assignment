package raisetech.student.management.model.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.management.model.data.Student;
import raisetech.student.management.model.data.StudentCourse;

/**
 * 受講生および受講生コースの情報をDBから取得する。
 */
@Mapper
public interface StudentRepository {

  /**
   * @return 受講生の情報を全件取得する。
   */
  @Select("SELECT * FROM students")
  List<Student> search();

  /**
   * @return 受講生のコース情報を全件取得する。
   */
  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentsCourses();
}
