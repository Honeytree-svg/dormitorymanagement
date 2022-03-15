package service;

import entity.Fix;
import util.ResultUtil;

public interface FixService {
    ResultUtil getFixList(Integer page, Integer limit);

    void insertFix(Fix fix);

    Fix getFixById(int id);

    void updateFix(Fix fix);

    void delFixById(int id);
}
