package com.example.roshannimje.baseballstadium.datamodel;

/**
 * Created by rutuja.kapadnis on 18-04-2018.
 */

public class UserDataModel {
    String userName;
    String zoneNo;
    String blockNo;
    String rowNo;
    String seatNo;

    public UserDataModel(String userName, String zoneNo, String blockNo, String rowNo, String seatNo) {
        this.userName = userName;
        this.zoneNo = zoneNo;
        this.blockNo = blockNo;
        this.rowNo = rowNo;
        this.seatNo = seatNo;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getZoneNo() {
        return zoneNo;
    }

    public void setZoneNo(String zoneNo) {
        this.zoneNo = zoneNo;
    }

    public String getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(String blockNo) {
        this.blockNo = blockNo;
    }

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}
