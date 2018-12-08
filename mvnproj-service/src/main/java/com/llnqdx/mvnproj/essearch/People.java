package com.llnqdx.mvnproj.essearch;

/**
 * @Auther: maofujiang
 * @Date: 2018/12/3
 * @Description:
 */
public class People {

    private String wxNo;
    private String sex;
    private String nickName;
    private double pointX;
    private double pointY;

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public People() {
    }

    public People(String wxNo, String sex, String nickName, double pointX, double pointY) {
        this.wxNo = wxNo;
        this.sex = sex;
        this.nickName = nickName;
        this.pointX = pointX;
        this.pointY = pointY;
    }
}
