package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by wannix on 1/4/17.
 */
@Entity
@Table(name = "m_check_inventry", catalog = "")
public class MCheckInventry {
    private int id;
    private Integer checkInventry;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CheckInventry", nullable = true)
    public Integer getCheckInventry() {
        return checkInventry;
    }

    public void setCheckInventry(Integer checkInventry) {
        this.checkInventry = checkInventry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MCheckInventry that = (MCheckInventry) o;

        if (checkInventry != null ? !checkInventry.equals(that.checkInventry) : that.checkInventry != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return checkInventry != null ? checkInventry.hashCode() : 0;
    }
}
