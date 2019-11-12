package com.ites.poswebservice.model.hotelinventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sancwk on 1/19/17.
 */
@Entity
public class Unit {
    private int unitId;
    private String unitType;
    private String description;

    @Id
    @Column(name = "unitId", nullable = false)
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unitType", nullable = true, length = 255)
    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (unitId != unit.unitId) return false;
        if (unitType != null ? !unitType.equals(unit.unitType) : unit.unitType != null) return false;
        if (description != null ? !description.equals(unit.description) : unit.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId;
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
