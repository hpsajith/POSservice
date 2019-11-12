package com.ites.poswebservice.model.reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by wannix on 1/3/17.
 */
@Entity
@Table(name = "currency_exchange", schema = "reservation", catalog = "")
public class CurrencyExchange implements Serializable{
    private static final long serialVersionUID = 1L;
    private int exchangeId;
    private Date exchangeDate;
    private Integer currencyId;
    private Double sellingPrice;
    private Double buyingPrice;
    private String comment;
    private String status;

    @Id
    @Column(name = "Exchange_Id", nullable = false)
    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Basic
    @Column(name = "Exchange_Date", nullable = true)
    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Basic
    @Column(name = "Currency_Id", nullable = true)
    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @Basic
    @Column(name = "Selling_Price", nullable = true, precision = 0)
    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Basic
    @Column(name = "Buying_Price", nullable = true, precision = 0)
    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Basic
    @Column(name = "Comment", nullable = true, length = 250)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "Status", nullable = true, length = 100)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyExchange that = (CurrencyExchange) o;

        if (exchangeId != that.exchangeId) return false;
        if (exchangeDate != null ? !exchangeDate.equals(that.exchangeDate) : that.exchangeDate != null) return false;
        if (currencyId != null ? !currencyId.equals(that.currencyId) : that.currencyId != null) return false;
        if (sellingPrice != null ? !sellingPrice.equals(that.sellingPrice) : that.sellingPrice != null) return false;
        if (buyingPrice != null ? !buyingPrice.equals(that.buyingPrice) : that.buyingPrice != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exchangeId;
        result = 31 * result + (exchangeDate != null ? exchangeDate.hashCode() : 0);
        result = 31 * result + (currencyId != null ? currencyId.hashCode() : 0);
        result = 31 * result + (sellingPrice != null ? sellingPrice.hashCode() : 0);
        result = 31 * result + (buyingPrice != null ? buyingPrice.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
