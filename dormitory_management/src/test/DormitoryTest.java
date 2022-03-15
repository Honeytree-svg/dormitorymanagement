import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DormitoryService;

public class DormitoryTest {

    @Test
    public void getDormitoryList(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        DormitoryService dormitoryService =apc.getBean(DormitoryService.class);
        System.out.println(dormitoryService.getDormitoryList(1,10).getData());
    }
}
