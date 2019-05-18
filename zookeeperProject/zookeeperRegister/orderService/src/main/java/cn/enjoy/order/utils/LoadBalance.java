package cn.enjoy.order.utils;

import java.util.List;

/**
 * Created on 2018/7/25.
 */
public abstract class LoadBalance {

    public volatile static List<String> SERVICE_LIST;

    public abstract String choseServiceHost();


}
