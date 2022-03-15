package dao;

import entity.RoleMenu;

import java.util.List;

public interface RoleMenuDao {
    List<RoleMenu> selMenusByRoleId(Long roleId);

    void deleteMenusByRoleId(Long roleId);

    void insert(RoleMenu roleMenu);
}
