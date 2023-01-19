package peaksoftjava8.dao;

import peaksoftjava8.config.DatabaseConnection;
import peaksoftjava8.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mukhammedasantegin
 * @project_name students_JDBC
 */
public class StudentDaoImpl implements StudentDao{

    private Connection connection;

    public StudentDaoImpl(){
        this.connection = DatabaseConnection.getConnection();

    }
    @Override
    public void creatTable() {
        String query = """
                create table if not exists students(
                id serial primary key,
                name varchar (50) not null,
                age smallint not null
                );
                """;

        try ( Statement statement = connection.createStatement();){
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void saveStudents(Student student) {
        String sqlQuery = """
                insert into students (name , age)
                values (?, ?);
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, student.getName());
            preparedStatement.setByte(2, student.getAge());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Student findByStudentId(Long studentId) {
        String query = """
                select * from students where id = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            Student student = new Student();

            if(!resultSet.next()){
                System.out.println("does not exists");
            }
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));

            resultSet.close();
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAllStudents() {

        List<Student> allStudents = new ArrayList<>();

        String query = """
                select * from students;
                """;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));

                allStudents.add(student);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allStudents;
    }

    @Override
    public void updateStudent(Long studentId, Student newStudent) {

        String query = """
                update students 
                set name = ? ,
                age = ?
                where id = ?
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, newStudent.getName());
            preparedStatement.setByte(2, newStudent.getAge());
            preparedStatement.setLong(3, studentId);

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Successfully updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteByStudentId(Long studentID) {

    }
}
