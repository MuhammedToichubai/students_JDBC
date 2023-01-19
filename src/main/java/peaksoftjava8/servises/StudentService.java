package peaksoftjava8.servises;

import peaksoftjava8.models.Student;

import java.util.List;

/**
 * @author mukhammedasantegin
 * @project_name students_JDBC
 */
public interface StudentService {
    // create table
    String creatTable();

    // save students
    String saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    //find all
    List<Student> findAllStudents();

    // update students
    String updateStudent(Long studentId, Student newStudent);

    //delete
    String deleteByStudentId(Long studentID);
}
