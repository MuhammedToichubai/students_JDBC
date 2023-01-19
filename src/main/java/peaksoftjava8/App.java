package peaksoftjava8;

import peaksoftjava8.models.Student;
import peaksoftjava8.servises.StudentService;
import peaksoftjava8.servises.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        StudentService service = new StudentServiceImpl();

        System.out.println(service.creatTable());

//        System.out.println(service.saveStudents(new Student("Azimbek", (byte) 16)));
//        System.out.println(service.saveStudents(new Student("Janyshbek", (byte) 18)));
//        System.out.println(service.saveStudents(new Student("Baiysh", (byte) 22)));
//        System.out.println(service.saveStudents(new Student("Osmon", (byte) 18)));

//        System.out.println(service.findByStudentId(4L));
//        service.findAllStudents().forEach(System.out::println);
//        service.updateStudent(21L, new Student("Jyidegul eje", (byte)18));


    }
}
