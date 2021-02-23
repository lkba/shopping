package com.lkb.service.goods;



public interface Auditing {
    public void add(Auditing auditing);

    public void delete(String id);

    public void delete(String[] ids);

}
