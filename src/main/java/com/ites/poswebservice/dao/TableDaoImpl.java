package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontKotBotMain;
import com.ites.poswebservice.model.hotelpos.TableConfig;
import com.ites.poswebservice.model.random.OpenTableDetail;
import com.ites.poswebservice.model.random.TableLoad;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ITESS
 *
 */
@Repository
public class TableDaoImpl implements TableDao {

    @Autowired
    private SessionFactory sessionFactoryHotelPos;

    public Session getPosSession() {
        return sessionFactoryHotelPos.openSession();
    }

    /*
     * @return List<TableConfig>
     * 
     * @exception @return null
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TableLoad> getAllTables(int restId,int userId) {
        int userType =1;
        String qry2 = "select userType from Userlogin where userID=" + userId;
        Object user = (Object) getPosSession().createQuery(qry2).uniqueResult();
        userType = Integer.parseInt(user.toString());
        
        String status = "";
        if(userType != 1){
        status = "and fkbm.userId='"+userId+"'";
        }
        
        String qry = "select new com.ites.poswebservice.model.random.TableLoad(tc.configid,tc.restrauntId,tc.room_Id,tc.table_Id,mrt.tableName,mrr.rname,"
                + "(select count(fkbm.openInTable) from FrontPosguest as fpg,FrontKotBotMain as fkbm where fpg.posGuestno=fkbm.posGuestno and fkbm.state='1' and fpg.states !='3' and fkbm.openInTable='1' and fkbm.tableNo=tc.table_Id and fkbm.resturentId='" + restId + "' "+ status+" )) "
                + " from TableConfig as tc, "
                + " MRestaurantTable as mrt,"
                + " MRestaurantRoom as mrr"
                + " where mrt.tableId = tc.table_Id and mrr.rno = tc.room_Id and mrr.resno ='" + restId + "'";

//			Session session = sessionFactoryPos.openSession();
        List<TableLoad> allTables = (List<TableLoad>) getPosSession().createQuery(qry).list();
        return allTables;
    }

    /*
     * Query the hotelpos DB via entityManager bean to get the table configs
     * related to the config id.
     * @param int id
     * @return TableConfig
     * @exception @return null
     */
    @Override
    public TableConfig getTable(int id) {
        String qry = "from TableConfig where configid=" + id;
        try {
            TableConfig table = (TableConfig) getPosSession().createQuery(qry).uniqueResult();
            return table;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ites.poswebservice.dao.hotelpos.TableDao#getOpenTableDetail(int)
     */
    @Override
    public List<OpenTableDetail> getOpenTableDetail(int tableId) {

        List<OpenTableDetail> openTableList = null;
        String qry = "select new com.ites.poswebservice.model.random.OpenTableDetail(mit.itemName,fpg.systemDate,fkbm.kotNo,fkbm.tableNo,fpg.posGuestno,fpg.roomNo,fkbi.itemCode,fkbi.itemNo,fkbi.qty,fkbi.unitPrices,miu.uName,ulg.userName,fkbi.taxClass,fkbi.unitPrices,fkbi.itemcomment,mit.currencyId)"
                + " from FrontKotBotItem as fkbi,"
                + " FrontKotBotMain as fkbm,"
                + " FrontPosguest as fpg,"
                + " MItem as mit,"
                + " MItemUnit as miu,"
                + " Userlogin  as ulg"
                + " where fkbi.kotBotNo = fkbm.kotNo "
                + " and ulg.userID = fkbm.userId "
                + " and fkbm.posGuestno = fpg.posGuestno "
                + " and fpg.states ='1' "
                + " and fkbi.itemCode = mit.itemCode "
                + " and mit.unitNo = miu.uNo "
                + " and fkbi.isSetMenu = '0' "
                + " and fkbm.openInTable = '1' "
                + " and fkbm.tableNo = '" + tableId + "' ";

        try {
            openTableList = (List<OpenTableDetail>) getPosSession().createQuery(qry).list();
            Object sumTax = null;
            int itemNo;
            Double itemPrices;
            Double sumOfTaxes;
            if (openTableList != null) {
                for (int i = 0; i < openTableList.size(); i++) {
                    itemNo = openTableList.get(i).getItemNo();
                    String qry2 = "select sum(fkbt.taxAmount) from FrontKotBotItem as fkbi,FrontKotBotTax as fkbt where  fkbi.itemNo = fkbt.kBItemNo and fkbt.kBItemNo =" + itemNo;
                    sumTax = (Object) getPosSession().createQuery(qry2).uniqueResult();
                    if (sumTax != null) {
                        sumOfTaxes = Double.parseDouble(sumTax.toString());
                        itemPrices = openTableList.get(i).getUnitPrice() * openTableList.get(i).getQty() + sumOfTaxes;
                        openTableList.get(i).setItemPrices(itemPrices);
                    } else {
                        openTableList.get(i).setItemPrices(0.00);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return openTableList;
    }

    @Override
    public void updateOpenTableState(Integer kotNo) {
        FrontKotBotMain fkbm = new FrontKotBotMain();
        String qry = "from FrontKotBotMain where kotNo=" + kotNo;
        fkbm = (FrontKotBotMain) getPosSession().createQuery(qry).uniqueResult();
        fkbm.setOpenInTable(0);
        fkbm.setIsEnter(0);
        Session session = getPosSession();
            session.beginTransaction();
            session.saveOrUpdate(fkbm);
            session.getTransaction().commit();
            session.close();
    }
}
