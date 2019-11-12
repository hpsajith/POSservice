package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelfinance.Inventoryposting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by wannix on 1/18/17.
 */
public class FinanceDaoImpl implements FinanceDao {
    private boolean isFinance = false;

    @Autowired
    private SessionFactory sessionFactoryHotelFinance;

    @Autowired
    private PosDao posDao;

    @Autowired
    private InventoryDao inventoryDao;

    public Session getFinanceSession() {
        return sessionFactoryHotelFinance.openSession();
    }

    @Override
    public void addFinancePosting(String bil, String refNo, String itemNo, int subDepNo, Double amt, String date, int uId, String rQty, String binIn, Double qty, int cat2) {
        try {
            isFinance = posDao.isFinance();
            if (isFinance) {
                String code = "FromPOS" + bil;
                String chAccC = posDao.getChOfItemExp(subDepNo, 1, cat2);
                String chAccD = posDao.getChOfItemExp(subDepNo, 2, cat2);
                BigDecimal issPrice = inventoryDao.getItemSubStorePrice(itemNo, rQty, binIn);
                BigDecimal cdAmt = new BigDecimal(String.valueOf(issPrice)).multiply(new BigDecimal(String.valueOf(qty)));

                Inventoryposting ip1 = new Inventoryposting();
                ip1.setReferenceNo(refNo);
                ip1.setAccountNo(chAccD);
                ip1.setSubDeptNo(subDepNo);
                ip1.setDescription(code);
                ip1.setCreditDebit(2);
                ip1.setAmount(cdAmt.doubleValue());
                ip1.setcAmount(0.0);
                ip1.setdAmount(cdAmt.doubleValue());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                ip1.setDate(df.parse(date));
                ip1.setUserId(uId);
                ip1.setPostingType("S");
                ip1.setItemNo(itemNo);

                Inventoryposting ip2 = new Inventoryposting();
                ip2.setReferenceNo(refNo);
                ip2.setAccountNo(chAccD);
                ip2.setSubDeptNo(subDepNo);
                ip2.setDescription(code);
                ip2.setCreditDebit(2);
                ip2.setAmount(cdAmt.doubleValue());
                ip2.setcAmount(0.0);
                ip2.setdAmount(cdAmt.doubleValue());
                ip2.setDate(df.parse(date));
                ip2.setUserId(uId);
                ip2.setPostingType("S");
                ip2.setItemNo(itemNo);

//                getFinanceSession().save(ip1);
                 try {
                    Session session2 = getFinanceSession();
                    session2.beginTransaction();
                    session2.save(ip1);
                    session2.getTransaction().commit();
                    session2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                getFinanceSession().save(ip2);
                 try {
                    Session session2 = getFinanceSession();
                    session2.beginTransaction();
                    session2.saveOrUpdate(ip2);
                    session2.getTransaction().commit();
                    session2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                posDao.financePostingPos(code, chAccC, chAccD, issPrice, cdAmt, refNo, itemNo, subDepNo, amt, date, uId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
