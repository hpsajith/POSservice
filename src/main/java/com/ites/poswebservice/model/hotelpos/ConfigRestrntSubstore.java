package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by sancwk on 1/18/17.
 */
@Entity
@Table(name = "config_restrnt_substore", catalog = "")
public class ConfigRestrntSubstore {
    private int id;
    private Integer restuarantId;
    private Integer invSubstore;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "restuarant_id", nullable = true)
    public Integer getRestuarantId() {
        return restuarantId;
    }

    public void setRestuarantId(Integer restuarantId) {
        this.restuarantId = restuarantId;
    }

    @Basic
    @Column(name = "inv_substore", nullable = true)
    public Integer getInvSubstore() {
        return invSubstore;
    }

    public void setInvSubstore(Integer invSubstore) {
        this.invSubstore = invSubstore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigRestrntSubstore that = (ConfigRestrntSubstore) o;

        if (id != that.id) return false;
        if (restuarantId != null ? !restuarantId.equals(that.restuarantId) : that.restuarantId != null) return false;
        if (invSubstore != null ? !invSubstore.equals(that.invSubstore) : that.invSubstore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (restuarantId != null ? restuarantId.hashCode() : 0);
        result = 31 * result + (invSubstore != null ? invSubstore.hashCode() : 0);
        return result;
    }
}
