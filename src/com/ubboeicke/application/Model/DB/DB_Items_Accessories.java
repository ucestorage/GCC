package com.ubboeicke.application.Model.DB;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ubbo Eicke on 30.05.2017.
 */
public class DB_Items_Accessories implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
