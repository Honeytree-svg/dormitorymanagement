package service;

import entity.Fee;
import util.ResultUtil;

import java.util.List;

public interface FeeService {
    ResultUtil getClassList(Integer page, Integer limit);


    void updateFee(Fee fee);

    Fee getFeeById(int id);

}
