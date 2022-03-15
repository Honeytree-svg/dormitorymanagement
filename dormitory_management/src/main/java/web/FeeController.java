package web;

import entity.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FeeService;
import util.ResultUtil;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/fee")
public class FeeController {

    @Autowired
    private FeeService feeService;


    @RequestMapping("/feeList")
    public String feeList(){
        return "/jsp/fee/feeList";
    }

    @RequestMapping("/getFeeList")
    @ResponseBody
    public ResultUtil getCleanList(Integer page, Integer limit)
    {
        //这是带分页的查询
        return feeService.getClassList(page,limit);
    }

    @RequestMapping("/updateFee")
    @ResponseBody
    public ResultUtil updateFee(Fee fee){
//        Fee fee1=new Fee();
//        fee1.setFee(fee);
//        fee1.setDormitoryId(dormitoryId);
        System.out.println(fee);
        try{
            feeService.updateFee(fee);
            return ResultUtil.ok();
        }catch (Exception e){
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }
    }


    @RequestMapping("/editFee/{id}")
    public String editFee(@PathVariable("id")int id, HttpSession session)
    {
        Fee fee1=feeService.getFeeById(id);
        session.setAttribute("fee1",fee1);
        return "/jsp/fee/editFee";
    }
}
