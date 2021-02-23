package com.lkb.pojo.teammanager;

import java.io.Serializable;

public class TableOutUserBasic implements Serializable {
    private TableOut tableOut;
    private User user;
    private BasicInfor basicInfor;

    public TableOut getTableOut() {
        return tableOut;
    }

    public void setTableOut(TableOut tableOut) {
        this.tableOut = tableOut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BasicInfor getBasicInfor() {
        return basicInfor;
    }

    public void setBasicInfor(BasicInfor basicInfor) {
        this.basicInfor = basicInfor;
    }

    @Override
    public String toString() {
        return "TableOutUserBasic{" +
                "tableOut=" + tableOut +
                ", user=" + user +
                ", basicInfor=" + basicInfor +
                '}';
    }
}
