package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "front_posguest", catalog = "")
public class FrontPosguest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "posGuest_no")
    private Integer posGuestno;
    @Column(name = "table_no")
    private Integer tableNo;
    @Column(name = "waiter_no")
    private Integer waiterNo;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "adult")
    private Integer adult;
    @Column(name = "children")
    private Integer children;
    @Column(name = "tableDate")
    @Temporal(TemporalType.DATE)
    private Date tableDate;
    @Column(name = "remrk")
    private String remrk;
    @Column(name = "states")
    private Integer states;
    @Column(name = "SystemDate")
    @Temporal(TemporalType.DATE)
    private Date systemDate;
    @Column(name = "strart_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date strartTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "TransactionNo")
    private String transactionNo;
    @Column(name = "isTax")
    private Integer isTax;
    @Column(name = "RoomNo")
    private String roomNo;
    @Column(name = "ConfNo")
    private Integer confNo;
    @Column(name = "mealCheck")
    private Integer mealCheck;
    @Column(name = "mealNo")
    private Integer mealNo;
    @Column(name = "walkingGuest")
    private Integer walkingGuest;
    @Column(name = "miniBar")
    private Integer miniBar;
    @Column(name = "Guest_states")
    private Integer gueststates;
    @Column(name = "House_No")
    private Integer houseNo;
    @Column(name = "package")
    private String package1;

    public FrontPosguest(){
    }
    
    public Integer getPosGuestno() {
        return posGuestno;
    }

    public void setPosGuestno(Integer posGuestno) {
        this.posGuestno = posGuestno;
    }

    public Integer getTableNo() {
        return tableNo;
    }

    public void setTableNo(Integer tableNo) {
        this.tableNo = tableNo;
    }

    public Integer getWaiterNo() {
        return waiterNo;
    }

    public void setWaiterNo(Integer waiterNo) {
        this.waiterNo = waiterNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Date getTableDate() {
        return tableDate;
    }

    public void setTableDate(Date tableDate) {
        this.tableDate = tableDate;
    }

    public String getRemrk() {
        return remrk;
    }

    public void setRemrk(String remrk) {
        this.remrk = remrk;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    public Date getStrartTime() {
        return strartTime;
    }

    public void setStrartTime(Date strartTime) {
        this.strartTime = strartTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Integer getIsTax() {
        return isTax;
    }

    public void setIsTax(Integer isTax) {
        this.isTax = isTax;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getConfNo() {
        return confNo;
    }

    public void setConfNo(Integer confNo) {
        this.confNo = confNo;
    }

    public Integer getMealCheck() {
        return mealCheck;
    }

    public void setMealCheck(Integer mealCheck) {
        this.mealCheck = mealCheck;
    }

    public Integer getMealNo() {
        return mealNo;
    }

    public void setMealNo(Integer mealNo) {
        this.mealNo = mealNo;
    }

    public Integer getWalkingGuest() {
        return walkingGuest;
    }

    public void setWalkingGuest(Integer walkingGuest) {
        this.walkingGuest = walkingGuest;
    }

    public Integer getMiniBar() {
        return miniBar;
    }

    public void setMiniBar(Integer miniBar) {
        this.miniBar = miniBar;
    }

    public Integer getGueststates() {
        return gueststates;
    }

    public void setGueststates(Integer gueststates) {
        this.gueststates = gueststates;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public String getPackage1() {
        return package1;
    }

    public void setPackage1(String package1) {
        this.package1 = package1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posGuestno != null ? posGuestno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontPosguest)) {
            return false;
        }
        FrontPosguest other = (FrontPosguest) object;
        if ((this.posGuestno == null && other.posGuestno != null) || (this.posGuestno != null && !this.posGuestno.equals(other.posGuestno))) {
            return false;
        }
        return true;
    }


    
}
