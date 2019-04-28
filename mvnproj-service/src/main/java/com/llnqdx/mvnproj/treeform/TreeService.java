package com.llnqdx.mvnproj.treeform;

import java.util.List;

/**
 * @Auther: marvinmao
 * @Date: 2019/4/28
 * @Description:
 */
public interface TreeService {

    List<TreeModel> formatDataToTree(List<TreeModel> rootMenu);

}
