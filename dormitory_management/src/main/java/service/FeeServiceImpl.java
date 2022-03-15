package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.FeeDao;
import entity.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ResultUtil;

import java.util.List;

@Service
public class FeeServiceImpl implements FeeService{
    @Autowired
    private FeeDao feeDao;

    @Override
    public ResultUtil getClassList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Fee> fees=feeDao.getFeeList();
        PageInfo<Fee> feePageInfo=new PageInfo<>(fees);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(feePageInfo.getTotal());

        resultUtil.setData(feePageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }


    @Override
    public void updateFee(Fee fee) {
        feeDao.updateFee(fee);
    }

    @Override
    public Fee getFeeById(int id) {
        return feeDao.getFeeById(id);
    }
}
