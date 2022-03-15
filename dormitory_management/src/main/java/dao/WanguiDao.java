package dao;

import entity.Wangui;

import java.util.List;

public interface WanguiDao {
    List<Wangui> getWanguiList();

    void insertWangui(Wangui wangui);

    Wangui getWanguiById(int id);

    void delWanguiById(int id);
}
