package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by sancwk on 1/19/17.
 */
@Entity
@Table(name = "config_item_coa", catalog = "")
public class ConfigItemCoa {
    private int pkNo;
    private int cat2No;
    private String subDep;

    @Id
    @Column(name = "pk_no", nullable = false)
    public int getPkNo() {
        return pkNo;
    }

    public void setPkNo(int pkNo) {
        this.pkNo = pkNo;
    }

    @Basic
    @Column(name = "cat2_no", nullable = false)
    public int getCat2No() {
        return cat2No;
    }

    public void setCat2No(int cat2No) {
        this.cat2No = cat2No;
    }

    @Basic
    @Column(name = "sub_dep", nullable = true, length = 10)
    public String getSubDep() {
        return subDep;
    }

    public void setSubDep(String subDep) {
        this.subDep = subDep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigItemCoa that = (ConfigItemCoa) o;

        if (pkNo != that.pkNo) return false;
        if (cat2No != that.cat2No) return false;
        if (subDep != null ? !subDep.equals(that.subDep) : that.subDep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkNo;
        result = 31 * result + cat2No;
        result = 31 * result + (subDep != null ? subDep.hashCode() : 0);
        return result;
    }
}
