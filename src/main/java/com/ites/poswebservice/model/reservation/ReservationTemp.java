/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.reservation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "reservation_temp")
@NamedQueries({
    @NamedQuery(name = "ReservationTemp.findAll", query = "SELECT r FROM ReservationTemp r")})
public class ReservationTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReservationNo")
    private Integer reservationNo;
    @Column(name = "ArrivalDate")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "DepartDate")
    @Temporal(TemporalType.DATE)
    private Date departDate;
    @Column(name = "No_of_Night")
    private Integer noofNight;
    @Column(name = "Room_type")
    private Integer roomtype;
    @Size(max = 100)
    @Column(name = "Company")
    private String company;
    @Column(name = "No_of_adults")
    private Integer noofadults;
    @Column(name = "No_of_children")
    private Integer noofchildren;
    @Column(name = "Rlwy")
    private Integer rlwy;
    @Column(name = "Crib")
    private Integer crib;
    @Column(name = "No_of_room")
    private Integer noofroom;
    @Column(name = "Corparate_id")
    private Integer corparateid;
    @Column(name = "Arial_time")
    @Temporal(TemporalType.TIME)
    private Date arialtime;
    @Size(max = 255)
    @Column(name = "Booked_by_name")
    private String bookedbyname;
    @Size(max = 255)
    @Column(name = "Booked_by_phone")
    private String bookedbyphone;
    @Size(max = 255)
    @Column(name = "Market_Category")
    private String marketCategory;
    @Size(max = 255)
    @Column(name = "Source")
    private String source;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Room_rate")
    private Double roomrate;
    @Size(max = 255)
    @Column(name = "Confirmation_no")
    private String confirmationno;
    @Column(name = "Guest_NO")
    private Integer guestNO;
    @Column(name = "Reservation_is_done")
    private Integer reservationisdone;
    @Size(max = 100)
    @Column(name = "RoomNo")
    private String roomNo;
    @Column(name = "state")
    private Integer state;
    @Column(name = "force_sell")
    private Boolean forceSell;
    @Column(name = "hide_sell")
    private Boolean hideSell;
    @Column(name = "non_smorking")
    private Boolean nonSmorking;
    @Size(max = 255)
    @Column(name = "Package")
    private String package1;
    @Column(name = "Rate_Type")
    private Integer rateType;
    @Column(name = "User_Id")
    private Integer userId;
    @Column(name = "InDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;
    @Column(name = "RoomAccRate")
    private Double roomAccRate;
    @Size(max = 250)
    @Column(name = "ReasonForceSell")
    private String reasonForceSell;
    @Column(name = "is_Room_no_Changes")
    private Integer isRoomnoChanges;
    @Size(max = 100)
    @Column(name = "Regd_card_no")
    private String regdcardno;
    @Size(max = 100)
    @Column(name = "Voucher_no")
    private String voucherno;
    @Column(name = "ExchangeId")
    private Integer exchangeId;
    @Column(name = "CurrencyValue")
    private BigDecimal currencyValue;
    @Column(name = "isTax")
    private Integer isTax;
    @Column(name = "rsroomRate")
    private Double rsroomRate;
    @Column(name = "isCompliment")
    private Integer isCompliment;
    @Size(max = 15)
    @Column(name = "Arrival_on")
    private String arrivalon;
    @Size(max = 15)
    @Column(name = "Depart_after")
    private String departafter;
    @Column(name = "Discount_Date")
    @Temporal(TemporalType.DATE)
    private Date discountDate;
    @Size(max = 5)
    @Column(name = "Complimenttype")
    private String complimenttype;
    @Size(max = 20)
    @Column(name = "MarketType")
    private String marketType;
    @Column(name = "isguide")
    private Integer isguide;
    @Column(name = "ExtraBed_Adults")
    private Integer extraBedAdults;
    @Column(name = "ExtraBed_Child")
    private Integer extraBedChild;
    @Column(name = "waitList")
    private Integer waitList;
    @Size(max = 200)
    @Column(name = "tourNo")
    private String tourNo;
    @Size(max = 200)
    @Column(name = "tourRef")
    private String tourRef;
    @Size(max = 200)
    @Column(name = "Msegment")
    private String msegment;
    @Column(name = "SubResGNo")
    private Integer subResGNo;
    @Column(name = "Dep_time")
    @Temporal(TemporalType.TIME)
    private Date deptime;
    @Column(name = "DNM")
    private Integer dnm;
    @Column(name = "DisPrentage")
    private Double disPrentage;
    @Column(name = "DisValue")
    private Double disValue;
    @Column(name = "Supplementry")
    private Integer supplementry;
    @Column(name = "istwin")
    private Integer istwin;
    @Column(name = "DND")
    private Integer dnd;
    @Column(name = "isallotment")
    private Integer isallotment;
    @Column(name = "nightAudtStop")
    private Integer nightAudtStop;
    @Column(name = "StopCredit")
    private Integer stopCredit;
    @Column(name = "ExPaxRate")
    private Double exPaxRate;
    @Column(name = "ExBedRate")
    private Double exBedRate;

    public ReservationTemp() {
    }

    public ReservationTemp(Integer reservationNo) {
        this.reservationNo = reservationNo;
    }

    public Integer getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Integer reservationNo) {
        this.reservationNo = reservationNo;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Integer getNoofNight() {
        return noofNight;
    }

    public void setNoofNight(Integer noofNight) {
        this.noofNight = noofNight;
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getNoofadults() {
        return noofadults;
    }

    public void setNoofadults(Integer noofadults) {
        this.noofadults = noofadults;
    }

    public Integer getNoofchildren() {
        return noofchildren;
    }

    public void setNoofchildren(Integer noofchildren) {
        this.noofchildren = noofchildren;
    }

    public Integer getRlwy() {
        return rlwy;
    }

    public void setRlwy(Integer rlwy) {
        this.rlwy = rlwy;
    }

    public Integer getCrib() {
        return crib;
    }

    public void setCrib(Integer crib) {
        this.crib = crib;
    }

    public Integer getNoofroom() {
        return noofroom;
    }

    public void setNoofroom(Integer noofroom) {
        this.noofroom = noofroom;
    }

    public Integer getCorparateid() {
        return corparateid;
    }

    public void setCorparateid(Integer corparateid) {
        this.corparateid = corparateid;
    }

    public Date getArialtime() {
        return arialtime;
    }

    public void setArialtime(Date arialtime) {
        this.arialtime = arialtime;
    }

    public String getBookedbyname() {
        return bookedbyname;
    }

    public void setBookedbyname(String bookedbyname) {
        this.bookedbyname = bookedbyname;
    }

    public String getBookedbyphone() {
        return bookedbyphone;
    }

    public void setBookedbyphone(String bookedbyphone) {
        this.bookedbyphone = bookedbyphone;
    }

    public String getMarketCategory() {
        return marketCategory;
    }

    public void setMarketCategory(String marketCategory) {
        this.marketCategory = marketCategory;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getRoomrate() {
        return roomrate;
    }

    public void setRoomrate(Double roomrate) {
        this.roomrate = roomrate;
    }

    public String getConfirmationno() {
        return confirmationno;
    }

    public void setConfirmationno(String confirmationno) {
        this.confirmationno = confirmationno;
    }

    public Integer getGuestNO() {
        return guestNO;
    }

    public void setGuestNO(Integer guestNO) {
        this.guestNO = guestNO;
    }

    public Integer getReservationisdone() {
        return reservationisdone;
    }

    public void setReservationisdone(Integer reservationisdone) {
        this.reservationisdone = reservationisdone;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getForceSell() {
        return forceSell;
    }

    public void setForceSell(Boolean forceSell) {
        this.forceSell = forceSell;
    }

    public Boolean getHideSell() {
        return hideSell;
    }

    public void setHideSell(Boolean hideSell) {
        this.hideSell = hideSell;
    }

    public Boolean getNonSmorking() {
        return nonSmorking;
    }

    public void setNonSmorking(Boolean nonSmorking) {
        this.nonSmorking = nonSmorking;
    }

    public String getPackage1() {
        return package1;
    }

    public void setPackage1(String package1) {
        this.package1 = package1;
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Double getRoomAccRate() {
        return roomAccRate;
    }

    public void setRoomAccRate(Double roomAccRate) {
        this.roomAccRate = roomAccRate;
    }

    public String getReasonForceSell() {
        return reasonForceSell;
    }

    public void setReasonForceSell(String reasonForceSell) {
        this.reasonForceSell = reasonForceSell;
    }

    public Integer getIsRoomnoChanges() {
        return isRoomnoChanges;
    }

    public void setIsRoomnoChanges(Integer isRoomnoChanges) {
        this.isRoomnoChanges = isRoomnoChanges;
    }

    public String getRegdcardno() {
        return regdcardno;
    }

    public void setRegdcardno(String regdcardno) {
        this.regdcardno = regdcardno;
    }

    public String getVoucherno() {
        return voucherno;
    }

    public void setVoucherno(String voucherno) {
        this.voucherno = voucherno;
    }

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    public BigDecimal getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(BigDecimal currencyValue) {
        this.currencyValue = currencyValue;
    }

    public Integer getIsTax() {
        return isTax;
    }

    public void setIsTax(Integer isTax) {
        this.isTax = isTax;
    }

    public Double getRsroomRate() {
        return rsroomRate;
    }

    public void setRsroomRate(Double rsroomRate) {
        this.rsroomRate = rsroomRate;
    }

    public Integer getIsCompliment() {
        return isCompliment;
    }

    public void setIsCompliment(Integer isCompliment) {
        this.isCompliment = isCompliment;
    }

    public String getArrivalon() {
        return arrivalon;
    }

    public void setArrivalon(String arrivalon) {
        this.arrivalon = arrivalon;
    }

    public String getDepartafter() {
        return departafter;
    }

    public void setDepartafter(String departafter) {
        this.departafter = departafter;
    }

    public Date getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(Date discountDate) {
        this.discountDate = discountDate;
    }

    public String getComplimenttype() {
        return complimenttype;
    }

    public void setComplimenttype(String complimenttype) {
        this.complimenttype = complimenttype;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public Integer getIsguide() {
        return isguide;
    }

    public void setIsguide(Integer isguide) {
        this.isguide = isguide;
    }

    public Integer getExtraBedAdults() {
        return extraBedAdults;
    }

    public void setExtraBedAdults(Integer extraBedAdults) {
        this.extraBedAdults = extraBedAdults;
    }

    public Integer getExtraBedChild() {
        return extraBedChild;
    }

    public void setExtraBedChild(Integer extraBedChild) {
        this.extraBedChild = extraBedChild;
    }

    public Integer getWaitList() {
        return waitList;
    }

    public void setWaitList(Integer waitList) {
        this.waitList = waitList;
    }

    public String getTourNo() {
        return tourNo;
    }

    public void setTourNo(String tourNo) {
        this.tourNo = tourNo;
    }

    public String getTourRef() {
        return tourRef;
    }

    public void setTourRef(String tourRef) {
        this.tourRef = tourRef;
    }

    public String getMsegment() {
        return msegment;
    }

    public void setMsegment(String msegment) {
        this.msegment = msegment;
    }

    public Integer getSubResGNo() {
        return subResGNo;
    }

    public void setSubResGNo(Integer subResGNo) {
        this.subResGNo = subResGNo;
    }

    public Date getDeptime() {
        return deptime;
    }

    public void setDeptime(Date deptime) {
        this.deptime = deptime;
    }

    public Integer getDnm() {
        return dnm;
    }

    public void setDnm(Integer dnm) {
        this.dnm = dnm;
    }

    public Double getDisPrentage() {
        return disPrentage;
    }

    public void setDisPrentage(Double disPrentage) {
        this.disPrentage = disPrentage;
    }

    public Double getDisValue() {
        return disValue;
    }

    public void setDisValue(Double disValue) {
        this.disValue = disValue;
    }

    public Integer getSupplementry() {
        return supplementry;
    }

    public void setSupplementry(Integer supplementry) {
        this.supplementry = supplementry;
    }

    public Integer getIstwin() {
        return istwin;
    }

    public void setIstwin(Integer istwin) {
        this.istwin = istwin;
    }

    public Integer getDnd() {
        return dnd;
    }

    public void setDnd(Integer dnd) {
        this.dnd = dnd;
    }

    public Integer getIsallotment() {
        return isallotment;
    }

    public void setIsallotment(Integer isallotment) {
        this.isallotment = isallotment;
    }

    public Integer getNightAudtStop() {
        return nightAudtStop;
    }

    public void setNightAudtStop(Integer nightAudtStop) {
        this.nightAudtStop = nightAudtStop;
    }

    public Integer getStopCredit() {
        return stopCredit;
    }

    public void setStopCredit(Integer stopCredit) {
        this.stopCredit = stopCredit;
    }

    public Double getExPaxRate() {
        return exPaxRate;
    }

    public void setExPaxRate(Double exPaxRate) {
        this.exPaxRate = exPaxRate;
    }

    public Double getExBedRate() {
        return exBedRate;
    }

    public void setExBedRate(Double exBedRate) {
        this.exBedRate = exBedRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationNo != null ? reservationNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationTemp)) {
            return false;
        }
        ReservationTemp other = (ReservationTemp) object;
        if ((this.reservationNo == null && other.reservationNo != null) || (this.reservationNo != null && !this.reservationNo.equals(other.reservationNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.reservation.ReservationTemp[ reservationNo=" + reservationNo + " ]";
    }
    
}
