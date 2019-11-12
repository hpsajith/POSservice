package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by sancwk on 1/20/17.
 */
@Entity
@Table(name = "m_item_menu", catalog = "")
public class MItemMenu {
    private int pkNo;
    private Integer menuItemNo;
    private Integer itemNo;

    @Id
    @Column(name = "Pk_No", nullable = false)
    public int getPkNo() {
        return pkNo;
    }

    public void setPkNo(int pkNo) {
        this.pkNo = pkNo;
    }

    @Basic
    @Column(name = "Menu_item_No", nullable = true)
    public Integer getMenuItemNo() {
        return menuItemNo;
    }

    public void setMenuItemNo(Integer menuItemNo) {
        this.menuItemNo = menuItemNo;
    }

    @Basic
    @Column(name = "Item_No", nullable = true)
    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MItemMenu mItemMenu = (MItemMenu) o;

        if (pkNo != mItemMenu.pkNo) return false;
        if (menuItemNo != null ? !menuItemNo.equals(mItemMenu.menuItemNo) : mItemMenu.menuItemNo != null) return false;
        if (itemNo != null ? !itemNo.equals(mItemMenu.itemNo) : mItemMenu.itemNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkNo;
        result = 31 * result + (menuItemNo != null ? menuItemNo.hashCode() : 0);
        result = 31 * result + (itemNo != null ? itemNo.hashCode() : 0);
        return result;
    }
}
