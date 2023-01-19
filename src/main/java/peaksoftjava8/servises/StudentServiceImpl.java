package peaksoftjava8.servises;

import peaksoftjava8.dao.StudentDao;
import peaksoftjava8.dao.StudentDaoImpl;
import peaksoftjava8.models.Student;

import java.util.List;

/**
 * @author mukhammedasantegin
 * @project_name students_JDBC
 */
public class StudentServiceImpl implements StudentService{

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public String creatTable() {
        studentDao.creatTable();
        return "Successfully created";
    }

    @Override
    public String saveStudents(Student student) {
        studentDao.saveStudents(student);
        return "Successfully saved";
    }

    @Override
    public Student findByStudentId(Long studentId) {
        return studentDao.findByStudentId(studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        studentDao.updateStudent(studentId, newStudent);
        return "successfully update";
    }

    @Override
    public String deleteByStudentId(Long studentID) {
        return null;
    }
}
