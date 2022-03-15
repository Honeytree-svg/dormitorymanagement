package dao;

import entity.Fee;

import java.util.List;

public interface FeeDao {
    List<Fee> getFeeList();

    void updateFee(Fee fee);

    Fee getFeeById(int id);
}
