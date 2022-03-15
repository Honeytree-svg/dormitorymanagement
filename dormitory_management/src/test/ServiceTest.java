import dao.FeeDao;
import entity.Admin;
import entity.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.FeeService;

import java.util.List;


public class ServiceTest {
    @Test
    public void test(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        AdminService adminService=apc.getBean(AdminService.class);
        Admin admin=new Admin();
        admin.setEmail("1371171");
        admin.setNickname("tree");
        admin.setPassword("123456");
        admin.setPhone("123123");
        admin.setUsername("sunzhe");
        admin.setSex("男");
        admin.setRoleId(1l);
        adminService.insAdmin(admin);
        //adminService.delAdminById(7l);
    }

    @Autowired
    private FeeDao feeDao;


    @Test
    public void test2(){

        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        FeeService feeService=apc.getBean(FeeService.class);
        //CleanService cleanService=apc.getBean(CleanService.class);
        List<Fee> fees= feeDao.getFeeList();
        //ResultUtil resultUtil=new ResultUtil();
        //resultUtil=cleanService.getClassList(0,10);
        //List<Clean> cleans=cleanDao.getCleanList();
        System.out.println(fees);
    }

    @Test
    public void updateFee(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        FeeService feeService=apc.getBean(FeeService.class);
        Fee fee=new Fee();
        fee.setDormitoryId(1);
        fee.setFee(5454.00);
        feeService.updateFee(fee);
    }

    @Test
    public void getFeeById(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring_root.xml");
        FeeService feeService=apc.getBean(FeeService.class);
        Fee fee=feeService.getFeeById(1);
        System.out.println(fee);
    }
}
