package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by sancwk on 1/19/17.
 */
@Entity
@Table(name = "config_bvg_coa", catalog = "")
public class ConfigBvgCoa {
    private String adChartOfAcc;
    private String description;
    private int pkNo;
    private Integer subDep;
    private Integer enType;
    private Integer invCat2No;
    private Integer invDep;

    @Basic
    @Column(name = "AdChartOfAcc", nullable = true, length = 50)
    public String getAdChartOfAcc() {
        return adChartOfAcc;
    }

    public void setAdChartOfAcc(String adChartOfAcc) {
        this.adChartOfAcc = adChartOfAcc;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "Pk_no", nullable = false)
    public int getPkNo() {
        return pkNo;
    }

    public void setPkNo(int pkNo) {
        this.pkNo = pkNo;
    }

    @Basic
    @Column(name = "sub_dep", nullable = true)
    public Integer getSubDep() {
        return subDep;
    }

    public void setSubDep(Integer subDep) {
        this.subDep = subDep;
    }

    @Basic
    @Column(name = "en_type", nullable = true)
    public Integer getEnType() {
        return enType;
    }

    public void setEnType(Integer enType) {
        this.enType = enType;
    }

    @Basic
    @Column(name = "invCat2No", nullable = true)
    public Integer getInvCat2No() {
        return invCat2No;
    }

    public void setInvCat2No(Integer invCat2No) {
        this.invCat2No = invCat2No;
    }

    @Basic
    @Column(name = "invDep", nullable = true)
    public Integer getInvDep() {
        return invDep;
    }

    public void setInvDep(Integer invDep) {
        this.invDep = invDep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigBvgCoa that = (ConfigBvgCoa) o;

        if (pkNo != that.pkNo) return false;
        if (adChartOfAcc != null ? !adChartOfAcc.equals(that.adChartOfAcc) : that.adChartOfAcc != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (subDep != null ? !subDep.equals(that.subDep) : that.subDep != null) return false;
        if (enType != null ? !enType.equals(that.enType) : that.enType != null) return false;
        if (invCat2No != null ? !invCat2No.equals(that.invCat2No) : that.invCat2No != null) return false;
        if (invDep != null ? !invDep.equals(that.invDep) : that.invDep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adChartOfAcc != null ? adChartOfAcc.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + pkNo;
        result = 31 * result + (subDep != null ? subDep.hashCode() : 0);
        result = 31 * result + (enType != null ? enType.hashCode() : 0);
        result = 31 * result + (invCat2No != null ? invCat2No.hashCode() : 0);
        result = 31 * result + (invDep != null ? invDep.hashCode() : 0);
        return result;
    }
}
