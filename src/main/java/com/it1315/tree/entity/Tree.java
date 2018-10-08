package com.it1315.tree.entity;

import java.io.Serializable;

/**
 * Created by dly on 2018/10/8
 */
public class Tree implements Serializable {

    private static final long serialVersionUID = 2972493714777795793L;

    private Integer id;
    private Double lon;
    private Double lat;
    private String treeType;
    private Double hight;
    private Double crown;
    private Integer age;
    private String photoPath;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public Double getHight() {
        return hight;
    }

    public void setHight(Double hight) {
        this.hight = hight;
    }

    public Double getCrown() {
        return crown;
    }

    public void setCrown(Double crown) {
        this.crown = crown;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", lon=" + lon +
                ", lat=" + lat +
                ", treeType='" + treeType + '\'' +
                ", higth=" + hight +
                ", crown=" + crown +
                ", age=" + age +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
