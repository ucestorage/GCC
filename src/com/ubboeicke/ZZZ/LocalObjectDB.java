package com.ubboeicke.ZZZ;



import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * Created by Ubbo Eicke on 30.05.2017.
 */
public class LocalObjectDB implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<String> list;
    private Map<String, String> map;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
