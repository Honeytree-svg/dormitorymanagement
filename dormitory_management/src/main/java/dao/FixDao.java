package dao;

import entity.Fix;

import java.util.List;

public interface FixDao {
    List<Fix> getFixList();

    void insertFix(Fix fix);

    Fix getFixById(int id);

    void updateFix(Fix fix);

    void delFixById(int id);
}
