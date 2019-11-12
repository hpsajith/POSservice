package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by wannix on 1/4/17.
 */
@Entity
@Table(name = "front_kot_bot_menu", catalog = "")
public class FrontKotBotMenu {
    private int menuId;
    private Integer kotBotNo;
    private Integer isSetmenu;
    private Integer setMenuNo;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "menu_id", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "kot_bot_no", nullable = true)
    public Integer getKotBotNo() {
        return kotBotNo;
    }

    public void setKotBotNo(Integer kotBotNo) {
        this.kotBotNo = kotBotNo;
    }

    @Basic
    @Column(name = "is_setmenu", nullable = true)
    public Integer getIsSetmenu() {
        return isSetmenu;
    }

    public void setIsSetmenu(Integer isSetmenu) {
        this.isSetmenu = isSetmenu;
    }

    @Basic
    @Column(name = "set_menu_no", nullable = true)
    public Integer getSetMenuNo() {
        return setMenuNo;
    }

    public void setSetMenuNo(Integer setMenuNo) {
        this.setMenuNo = setMenuNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrontKotBotMenu that = (FrontKotBotMenu) o;

        if (menuId != that.menuId) return false;
        if (kotBotNo != null ? !kotBotNo.equals(that.kotBotNo) : that.kotBotNo != null) return false;
        if (isSetmenu != null ? !isSetmenu.equals(that.isSetmenu) : that.isSetmenu != null) return false;
        if (setMenuNo != null ? !setMenuNo.equals(that.setMenuNo) : that.setMenuNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuId;
        result = 31 * result + (kotBotNo != null ? kotBotNo.hashCode() : 0);
        result = 31 * result + (isSetmenu != null ? isSetmenu.hashCode() : 0);
        result = 31 * result + (setMenuNo != null ? setMenuNo.hashCode() : 0);
        return result;
    }
}
