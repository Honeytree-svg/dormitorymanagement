import dao.FixDao;
import dao.WanguiDao;
import entity.Wangui;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.WanguiService;
import util.ResultUtil;

import java.util.Date;

public class WanguiTest {
    @Autowired
    private WanguiDao wanguiDao;
    @Autowired
    private FixDao fixDao;
    @Test
    public void getWanguiById(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        WanguiService wanguiService =apc.getBean(WanguiService.class);
        Wangui wangui=wanguiService.getWanguiById(1);
        System.out.println(wangui);
    }

    @Test
    public void getWanguiList(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        WanguiService wanguiService =apc.getBean(WanguiService.class);
        ResultUtil wangui=wanguiService.getWanguiList(1,10);
        System.out.println(wangui.getData());
    }

    @Test
    public void delWanguiById(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        WanguiService wanguiService =apc.getBean(WanguiService.class);
        wanguiService.delWanguiById(3);
    }

    @Test
    public void delWangui(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        WanguiService wanguiService =apc.getBean(WanguiService.class);
        Wangui wangui=new Wangui();
        wangui.setDormitoryId(1);
        wangui.setStudentId(1);
        wangui.setWanguiTime(new Date());
        wanguiService.insertWangui(wangui);
    }
}
