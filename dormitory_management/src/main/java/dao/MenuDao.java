package dao;

import entity.Menu;

import java.util.List;

public interface MenuDao {
    Menu getMenuById(Long menuId);

    List<Menu> getAllMenus();
}
