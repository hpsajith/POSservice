/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.reservation;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "reservation_conf")
@NamedQueries({
    @NamedQuery(name = "ReservationConf.findAll", query = "SELECT r FROM ReservationConf r")})
public class ReservationConf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Conf_No")
    private Integer confNo;
    @Column(name = "Guest_No")
    private Integer guestNo;
    @Column(name = "resevation_No")
    private Integer resevationNo;
    @Column(name = "corparate_No")
    private Integer corparateNo;
    @Size(max = 500)
    @Column(name = "Guest_comment")
    private String guestcomment;
    @Size(max = 100)
    @Column(name = "Reservation_Guaranteed")
    private String reservationGuaranteed;
    @Column(name = "Guaranteed_methed")
    private Integer guaranteedmethed;
    @Column(name = "GuestStatus")
    private Integer guestStatus;
    @Size(max = 10)
    @Column(name = "Room_Charge")
    private String roomCharge;
    @Size(max = 10)
    @Column(name = "Phone_Charge")
    private String phoneCharge;
    @Size(max = 10)
    @Column(name = "Food_Charge")
    private String foodCharge;
    @Size(max = 10)
    @Column(name = "Bevarage_Charge")
    private String bevarageCharge;
    @Size(max = 10)
    @Column(name = "Miscellaneous_Charge")
    private String miscellaneousCharge;
    @Size(max = 10)
    @Column(name = "Shops_Charge")
    private String shopsCharge;
    @Column(name = "bill_type_A")
    private Integer billtypeA;
    @Column(name = "bill_type_B")
    private Integer billtypeB;
    @Column(name = "bill_type_C")
    private Integer billtypeC;
    @Column(name = "TravelAgent_No")
    private Integer travelAgentNo;
    @Column(name = "ButlerNo")
    private Integer butlerNo;
    @Column(name = "WalkinNo")
    private Integer walkinNo;
    @Column(name = "reservation_NO_group")
    private Integer reservationNOgroup;
    @Column(name = "invoiceNo")
    private Integer invoiceNo;
    @Column(name = "isPrint")
    private Integer isPrint;
    @Column(name = "AisPrint")
    private Integer aisPrint;
    @Column(name = "BisPrint")
    private Integer bisPrint;
    @Column(name = "CisPrint")
    private Integer cisPrint;
    @Column(name = "chekOutNo")
    private Integer chekOutNo;
    @Column(name = "GRCNO")
    private Integer grcno;
    @Size(max = 500)
    @Column(name = "Guest_Comments")
    private String guestComments;
    @Size(max = 100)
    @Column(name = "GroupName")
    private String groupName;

    public ReservationConf() {
    }

    public ReservationConf(Integer confNo) {
        this.confNo = confNo;
    }

    public Integer getConfNo() {
        return confNo;
    }

    public void setConfNo(Integer confNo) {
        this.confNo = confNo;
    }

    public Integer getGuestNo() {
        return guestNo;
    }

    public void setGuestNo(Integer guestNo) {
        this.guestNo = guestNo;
    }

    public Integer getResevationNo() {
        return resevationNo;
    }

    public void setResevationNo(Integer resevationNo) {
        this.resevationNo = resevationNo;
    }

    public Integer getCorparateNo() {
        return corparateNo;
    }

    public void setCorparateNo(Integer corparateNo) {
        this.corparateNo = corparateNo;
    }

    public String getGuestcomment() {
        return guestcomment;
    }

    public void setGuestcomment(String guestcomment) {
        this.guestcomment = guestcomment;
    }

    public String getReservationGuaranteed() {
        return reservationGuaranteed;
    }

    public void setReservationGuaranteed(String reservationGuaranteed) {
        this.reservationGuaranteed = reservationGuaranteed;
    }

    public Integer getGuaranteedmethed() {
        return guaranteedmethed;
    }

    public void setGuaranteedmethed(Integer guaranteedmethed) {
        this.guaranteedmethed = guaranteedmethed;
    }

    public Integer getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(Integer guestStatus) {
        this.guestStatus = guestStatus;
    }

    public String getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(String roomCharge) {
        this.roomCharge = roomCharge;
    }

    public String getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(String phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    public String getFoodCharge() {
        return foodCharge;
    }

    public void setFoodCharge(String foodCharge) {
        this.foodCharge = foodCharge;
    }

    public String getBevarageCharge() {
        return bevarageCharge;
    }

    public void setBevarageCharge(String bevarageCharge) {
        this.bevarageCharge = bevarageCharge;
    }

    public String getMiscellaneousCharge() {
        return miscellaneousCharge;
    }

    public void setMiscellaneousCharge(String miscellaneousCharge) {
        this.miscellaneousCharge = miscellaneousCharge;
    }

    public String getShopsCharge() {
        return shopsCharge;
    }

    public void setShopsCharge(String shopsCharge) {
        this.shopsCharge = shopsCharge;
    }

    public Integer getBilltypeA() {
        return billtypeA;
    }

    public void setBilltypeA(Integer billtypeA) {
        this.billtypeA = billtypeA;
    }

    public Integer getBilltypeB() {
        return billtypeB;
    }

    public void setBilltypeB(Integer billtypeB) {
        this.billtypeB = billtypeB;
    }

    public Integer getBilltypeC() {
        return billtypeC;
    }

    public void setBilltypeC(Integer billtypeC) {
        this.billtypeC = billtypeC;
    }

    public Integer getTravelAgentNo() {
        return travelAgentNo;
    }

    public void setTravelAgentNo(Integer travelAgentNo) {
        this.travelAgentNo = travelAgentNo;
    }

    public Integer getButlerNo() {
        return butlerNo;
    }

    public void setButlerNo(Integer butlerNo) {
        this.butlerNo = butlerNo;
    }

    public Integer getWalkinNo() {
        return walkinNo;
    }

    public void setWalkinNo(Integer walkinNo) {
        this.walkinNo = walkinNo;
    }

    public Integer getReservationNOgroup() {
        return reservationNOgroup;
    }

    public void setReservationNOgroup(Integer reservationNOgroup) {
        this.reservationNOgroup = reservationNOgroup;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Integer getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
    }

    public Integer getAisPrint() {
        return aisPrint;
    }

    public void setAisPrint(Integer aisPrint) {
        this.aisPrint = aisPrint;
    }

    public Integer getBisPrint() {
        return bisPrint;
    }

    public void setBisPrint(Integer bisPrint) {
        this.bisPrint = bisPrint;
    }

    public Integer getCisPrint() {
        return cisPrint;
    }

    public void setCisPrint(Integer cisPrint) {
        this.cisPrint = cisPrint;
    }

    public Integer getChekOutNo() {
        return chekOutNo;
    }

    public void setChekOutNo(Integer chekOutNo) {
        this.chekOutNo = chekOutNo;
    }

    public Integer getGrcno() {
        return grcno;
    }

    public void setGrcno(Integer grcno) {
        this.grcno = grcno;
    }

    public String getGuestComments() {
        return guestComments;
    }

    public void setGuestComments(String guestComments) {
        this.guestComments = guestComments;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (confNo != null ? confNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationConf)) {
            return false;
        }
        ReservationConf other = (ReservationConf) object;
        if ((this.confNo == null && other.confNo != null) || (this.confNo != null && !this.confNo.equals(other.confNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.reservation.ReservationConf[ confNo=" + confNo + " ]";
    }
    
}
