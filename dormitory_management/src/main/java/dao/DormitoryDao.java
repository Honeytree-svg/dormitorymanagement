package dao;

import entity.Dormitory;

import java.util.List;

public interface DormitoryDao {
    List<Dormitory> getAllDormitories();


    List<Dormitory> getDormitoryList();

    List<Dormitory> getDormitoryList2();

    Dormitory checkDormitoryNumber(String dormitoryNumber);

    void insertDormitory(Dormitory dormitory);

    void deleteByDormitoryId(int dormitoryId);

    Dormitory getDormitoryById(int dormitoryId);
}
