package com.llnqdx.mvnproj.treeform.impl;

import com.llnqdx.mvnproj.treeform.TreeModel;
import com.llnqdx.mvnproj.treeform.TreeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: marvinmao
 * @Date: 2019/4/28
 * @Description:
 */
@Service
public class TreeServicImpl implements TreeService {
    @Override
    public List<TreeModel> formatDataToTree(List<TreeModel> rootMenu) {
        try {
            List<TreeModel> menuList = new ArrayList<>();
            // 先找到所有的一级菜单
            for (int i = 0; i < rootMenu.size(); i++) {
                // 一级菜单没有parentId
                if (rootMenu.get(i).getParentId() == null) {
                    menuList.add(rootMenu.get(i));
                }
            }
            // 为一级菜单设置子菜单，getChild是递归调用的
            for (TreeModel menu : menuList) {
                menu.setChildList(getChildDatas(menu.getUuid(), rootMenu));
            }
            return menuList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<TreeModel> getChildDatas(String parentId, List<TreeModel> rootMenu) {
        // 子菜单
        List<TreeModel> childList = new ArrayList<>();
        for (TreeModel menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId() != null) {
                if (menu.getParentId() == parentId) {
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (TreeModel menu : childList) {
            if (menu.getParentId() != null) {
                // 递归
                menu.setChildList(getChildDatas(menu.getUuid(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

}
