package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.WanguiDao;
import entity.Wangui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ResultUtil;

import java.util.List;
@Service
public class WanguiServiceImpl implements WanguiService{
    @Autowired
    private WanguiDao wanguiDao;
    @Override
    public ResultUtil getWanguiList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Wangui> wanguis=wanguiDao.getWanguiList();
        PageInfo<Wangui> wanguiPageInfo=new PageInfo<>(wanguis);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(wanguiPageInfo.getTotal());

        resultUtil.setData(wanguiPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }


    @Override
    public void insertWangui(Wangui wangui) {
        wanguiDao.insertWangui(wangui);
    }

    @Override
    public Wangui getWanguiById(int id) {
        return wanguiDao.getWanguiById(id);
    }

    @Override
    public void delWanguiById(int id) {
        wanguiDao.delWanguiById(id);
    }
}
