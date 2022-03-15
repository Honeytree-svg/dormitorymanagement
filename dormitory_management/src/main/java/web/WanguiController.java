package web;

import dao.DormitoryDao;
import dao.StudentDao;
import dao.WanguiDao;
import entity.Dormitory;
import entity.Student;
import entity.Wangui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.WanguiService;
import util.ResultUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/wangui")
public class WanguiController {

    @Autowired
    private DormitoryDao dormitoryDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private WanguiService wanguiService;
    @Autowired
    private WanguiDao wanguiDao;


    @RequestMapping("/wanguiList")
    public String wanguiList(){
        return "/jsp/wangui/wanguiList";
    }

    @RequestMapping("/getWanguiList")
    @ResponseBody
    public ResultUtil getWanguiList(Integer page, Integer limit)
    {
        //这是带分页的查询
        return wanguiService.getWanguiList(page,limit);
    }

    @RequestMapping("/insertWangui")
    @ResponseBody
    public ResultUtil updateWangui(Wangui wangui){
        System.out.println(wangui);
        try{
            wanguiService.insertWangui(wangui);
            return ResultUtil.ok();
        }catch (Exception e){
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }
    }


    @RequestMapping("/addWangui")
    public String editFee(HttpSession session)
    {
        List<Dormitory> dormitories=dormitoryDao.getDormitoryList();
        List<Student> students=studentDao.getAllStudent();

        session.setAttribute("dormitories",dormitories);
        session.setAttribute("students",students);

        return "/jsp/wangui/addWangui";
    }

    @RequestMapping("/delWangui/{id}")
    @ResponseBody
    public ResultUtil delFix(@PathVariable("id")int id){
        wanguiService.delWanguiById(id);
        return ResultUtil.ok();
    }
}
