package peaksoftjava8.dao;

import peaksoftjava8.models.Student;

import java.util.List;
import java.util.Map;

/**
 * @author mukhammedasantegin
 * @project_name students_JDBC
 */
public interface StudentDao {

    // create table
    void creatTable();

    // save students
    void saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    //find all
    List<Student> findAllStudents();

    // update students
    void updateStudent(Long studentId, Student newStudent);

    //delete
    void deleteByStudentId(Long studentID);

    List<Student> getAllStudentsSortByAge(String ascOrDesc);

    boolean checkByAge();

    void addColumnGender(Gender gender);

    Map<Gender, List<Student>> gruopByGender();

    void deleteAllStudents(); //ddl




}
