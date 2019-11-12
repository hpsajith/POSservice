package com.ites.poswebservice.model.random;

public class TableLoad {
	int configid;
	int restrauntId;
	int roomId;
	int tableId;
	String tableName;
	String restRoomName;
        int tableStatus;
	
	public TableLoad(int configid,int restrauntId,int roomId,int tableId,String tableName,String restRoomName){
		this.configid=configid;
		this.restrauntId=restrauntId;
		this.roomId=roomId;
		this.tableId=tableId;
		this.tableName=tableName;
		this.restRoomName =restRoomName;
	}
        
        public TableLoad(int configid,int restrauntId,int roomId,int tableId,String tableName,String restRoomName,long tableStatuss){
		this.configid=configid;
		this.restrauntId=restrauntId;
		this.roomId=roomId;
		this.tableId=tableId;
		this.tableName=tableName;
		this.restRoomName =restRoomName;
                if(tableStatuss >0){
                this.tableStatus = 1;
                }else{
                this.tableStatus = 0;
                }
                
	}
	
	public int getConfigid() {
		return configid;
	}
	public void setConfigid(int configid) {
		this.configid = configid;
	}
	public int getRestrauntId() {
		return restrauntId;
	}
	public void setRestrauntId(int restrauntId) {
		this.restrauntId = restrauntId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getRestRoomName() {
		return restRoomName;
	}

	public void setRestRoomName(String restRoomName) {
		this.restRoomName = restRoomName;
	}

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

	
	
}
