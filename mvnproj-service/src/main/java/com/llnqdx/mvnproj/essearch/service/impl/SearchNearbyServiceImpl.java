package com.llnqdx.mvnproj.essearch.service.impl;

import com.llnqdx.mvnproj.essearch.People;
import com.llnqdx.mvnproj.essearch.service.SearchNearbyService;
import com.llnqdx.mvnproj.utils.RandomUtils;

/**
 * @Auther: maofujiang
 * @Date: 2018/12/3
 * @Description:
 */
public class SearchNearbyServiceImpl implements SearchNearbyService {

    @Override
    public People randomPeople(double myLat, double myLon) {
        String wxNo = RandomUtils.createUUID();
        String sex = RandomUtils.randomNum(1, 2);
        String nickName = RandomUtils.randomString(10);
//        return new People(wxNo,sex,1,2);
        return null;
    }
}
