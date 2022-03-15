package service;

import entity.Wangui;
import util.ResultUtil;

import java.util.List;

public interface WanguiService {
    ResultUtil getWanguiList(Integer page, Integer limit);

    void insertWangui(Wangui Wangui);

    Wangui getWanguiById(int id);

    void delWanguiById(int id);


}
