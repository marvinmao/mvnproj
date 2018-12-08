package com.llnqdx.mvnproj.essearch.service;

import com.llnqdx.mvnproj.essearch.People;

/**
 * @Auther: maofujiang
 * @Date: 2018/12/3
 * @Description:ElasticSearch模拟实现搜索附近的人
 */
public interface SearchNearbyService {

    People randomPeople(double myLat, double myLon);

}
