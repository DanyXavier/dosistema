package com.dasofte.modelos.form;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class Paginacion {
    @QueryParam("pageNum")
    @DefaultValue("0")
    public int pageNum;

    @QueryParam("pageSize")
    @DefaultValue("10")
    public int pageSize;

    @QueryParam("total")
    public int total;


    @Override
    public String toString() {
        return "Paginacion{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
