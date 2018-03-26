package com.luhui1hao.beandemo.bean;

import java.util.*;

public class ComplexData {
    private String[] names;
    private List list;
    private Map map;
    private Properties properties;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "ComplexData{" +
                "names=" + Arrays.toString(names) +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
