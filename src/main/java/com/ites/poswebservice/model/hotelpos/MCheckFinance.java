package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by sancwk on 1/20/17.
 */
@Entity
@Table(name = "m_check_finance",catalog = "")
public class MCheckFinance {
    private Integer checkFinance;
    private int id;

    @Basic
    @Column(name = "CheckFinance", nullable = true)
    public Integer getCheckFinance() {
        return checkFinance;
    }

    public void setCheckFinance(Integer checkFinance) {
        this.checkFinance = checkFinance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MCheckFinance that = (MCheckFinance) o;

        if (checkFinance != null ? !checkFinance.equals(that.checkFinance) : that.checkFinance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return checkFinance != null ? checkFinance.hashCode() : 0;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
