package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by wannix on 1/9/17.
 */
@Entity
@Table(name = "front_kot_item_temp",  catalog = "")
public class FrontKotItemTemp {
    private Integer kotNo;
    private Integer itemCode;
    private Integer qty;
    private Integer type;
    private Integer printer;
    private int id;

    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "KotNo", nullable = true)
    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    @Column(name = "ItemCode", nullable = true)
    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    @Column(name = "Qty", nullable = true)
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Column(name = "Type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "printer", nullable = true)
    public Integer getPrinter() {
        return printer;
    }

    public void setPrinter(Integer printer) {
        this.printer = printer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrontKotItemTemp that = (FrontKotItemTemp) o;

        if (kotNo != null ? !kotNo.equals(that.kotNo) : that.kotNo != null) return false;
        if (itemCode != null ? !itemCode.equals(that.itemCode) : that.itemCode != null) return false;
        if (qty != null ? !qty.equals(that.qty) : that.qty != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (printer != null ? !printer.equals(that.printer) : that.printer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kotNo != null ? kotNo.hashCode() : 0;
        result = 31 * result + (itemCode != null ? itemCode.hashCode() : 0);
        result = 31 * result + (qty != null ? qty.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (printer != null ? printer.hashCode() : 0);
        return result;
    }

}
