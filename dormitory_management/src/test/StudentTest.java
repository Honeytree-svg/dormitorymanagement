
import entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;


public class StudentTest {

    @Test
    public void delWangui(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        Student student=new Student();
        student.setAddress("fsds");
        student.setDormitoryId(1);
        String s="123@qq.com";
        student.setEmail(s);
        student.setLevel(0);
        student.setSex(0);
        student.setPhone("12312341234");
        student.setNote("sfsf");
        student.setUsername("fsdfs");
        StudentService studentService=apc.getBean(StudentService.class);
        studentService.insertStudent(student);
    }
}
