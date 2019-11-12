package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelinventory.SubstoreInD;
import com.ites.poswebservice.model.hotelinventory.SubstoreOutD;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wannix on 1/18/17.
 */
public class InventoryDaoImpl implements InventoryDao {

    private boolean isFinance = false;

    @Autowired
    private SessionFactory sessionFactoryHotelInventory;

    @Autowired
    private PosDao posDao;

    @Autowired
    private FinanceDao financeDao;

    public Session getInventorySession() {
        return sessionFactoryHotelInventory.openSession();
    }

    @Override
    public BigDecimal getItemSubStorePrice(String iteNo, String rQty, String binIn) {
        BigDecimal issPrice = new BigDecimal("0");
        BigDecimal rQ = new BigDecimal(rQty);
        try {
//            Query hql = getInventorySession().createQuery("select s.unitPrice, u.description from SubstoreInD s inner join Item i on (s.iteNo = i.iteNo) inner join Unit u on (i.unitType = u.unitId) where (s.subInNo = :binIn and s.iteNo = :iteNo)").setString("binIn", binIn).setString("iteNo", iteNo);
            Query hql = getInventorySession().createQuery("select s.unitPrice, u.description from SubstoreInD s, Item i, Unit u where (s.iteNo = i.iteNo) and (i.unitType = u.unitId) and (s.subInNo = :binIn and s.iteNo = :iteNo)").setString("binIn", binIn).setString("iteNo", iteNo);
            List<Object[]> rs = hql.list();
            for (Object[] r : rs) {
                issPrice = new BigDecimal((double) r[0]).multiply(rQ);
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return issPrice;
    }

    @Override
    public int getBinNo(String itemCode) {
        int bin = 0;
        try {
            Query hql = getInventorySession().createQuery("select i.binNo as binNo from Itemvsbin i where itemNo=:itemCode").setString("itemCode", itemCode);
            List rs = hql.list();
            if (!rs.isEmpty()) {
                bin = ((Double) rs.get(0)).intValue();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bin;
    }

    @Override
    public String getRefCodePos() {
        String rCode = "0";
        String rC;
        try {
            Query hql = getInventorySession().createQuery("select nullif(count(grnCode), 0) as ma from BinOutDPos where grnCode like 'OD%'");
            List rs = hql.list();

            if (!rs.isEmpty()) {
                rC = String.valueOf(((Long) rs.get(0)).intValue() + 1);
                rCode = "OD" + rC;
            } else {
                rCode = "OD0";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rCode;
    }

    @Override
    public int addSubStorInventoryPos(int binNo, int subInNo, String grnDate, String refNo, double outQty, String itemCode, String startDate,
            int user, String grnCode, int pos, String bilNo, int binInNo, int invDepartment, int subStore,
            double unitPrice, String refCode) {
        int rNo = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SubstoreOutD ssod = new SubstoreOutD();
            ssod.setBinNo(binNo);
            ssod.setSubstoreInNo(subInNo);
            ssod.setGrnDate(df.parse(grnDate));
            ssod.setRefNo(refNo);
            ssod.setOutQty(outQty);
            ssod.setItemNo(itemCode);
            ssod.setStrDate(df.parse(startDate));
            ssod.setUser(user);
            ssod.setSubSep(invDepartment);
            ssod.setInCode(grnCode); // swap this with below one if something goes wrong
            ssod.setGrnCode(refCode); //
            ssod.setDescription(bilNo);
            ssod.setBinInNo(binInNo);
            ssod.setSubStockno(subStore);
            ssod.setUnitPrice(unitPrice);

//            getInventorySession().save(ssod);
            try {
                Session session2 = getInventorySession();
                session2.beginTransaction();
                session2.save(ssod);
                session2.getTransaction().commit();
                session2.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Query hql = getInventorySession().createQuery("select MAX(s.id)from SubstoreOutD s");
            List rs = hql.list();
            if (!rs.isEmpty()) {
                rNo = (int) rs.get(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rNo;
    }

    @Override
    public void updateSubStoreInventory(int binInNo, double balance) {
        try {
            SubstoreInD ssid = new SubstoreInD();
            ssid.setSubInNo(binInNo);
            ssid.setBalQty(balance);
//            getInventorySession().update(ssid);

            try {
                Session session2 = getInventorySession();
                session2.beginTransaction();
                session2.update(ssid);
                session2.getTransaction().commit();
                session2.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean checkInventory(String bil, int itemCode, int qty, String nightDate, int userId, int restaurantId) {
        boolean flag = false;
        int rbNo = 0;
        String refNo = "POS" + bil;
        try {
            List<Object[]> rs = posDao.getSubItems(itemCode);

            for (Object[] r : rs) {
                int invDepartment = posDao.getInvSubStore(itemCode, (String) r[0], restaurantId);
                Query hql = getInventorySession().createQuery("select nullif(sum(balQty), 0) as s from BinInDPos where balQty!=0 and iteNo=:subItemCode and subDep=:invDep").setString("subItemCode", (String) r[0]).setInteger("invDep", invDepartment);
                List rs1 = hql.list();

                if (!rs1.isEmpty()) {
                    BigDecimal bd = new BigDecimal((Double) r[1]);
                    bd = bd.multiply(new BigDecimal(String.valueOf(qty)));

                    int sumBalQty = 0;

                    if (rs1.get(0) != null) {
                        sumBalQty = (int) rs1.get(0);
                    }

                    if (sumBalQty >= bd.doubleValue()) {
                        flag = true;
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (rs.isEmpty()) {
                flag = true;
            }
            if (flag) {
                for (Object[] r : rs) {
                    int invSubStore = posDao.getInvSubStore(itemCode, (String) r[0], restaurantId);
                    BigDecimal bd = new BigDecimal((double) r[1]);
                    bd = bd.multiply(new BigDecimal(String.valueOf(qty)));
                    Query hql = getInventorySession().createQuery("select refNo,balQty,inQty, nullif(balQty, 0) as balance, inDate, binNo, subInNo, iteNo, grnCode, binInNo, subStoNo, unitPrice from SubstoreInD where iteNo=:subItemCode order by inDate desc").setString("subItemCode", (String) r[0]);
                    List<Object[]> rs1 = hql.list();

                    if (!rs1.isEmpty()) {
                        try {
                            for (Object[] r1 : rs1) {

                                BigDecimal bQ = new BigDecimal("0.00");
                                BigDecimal rQa = new BigDecimal("0.00");
                                int cat2 = getItemCat2No((String) r[0]);

                                Double rrQa = 0.00;
                                if (bd.doubleValue() <= ((r1[3] == null) ? 0.0 : (double) r1[3])) {
                                    BigDecimal bd1 = new BigDecimal(((r1[1] == null) ? 0.0 : (double) r1[1]));
                                    bd1 = bd1.subtract(new BigDecimal(String.valueOf(bd.doubleValue())));
                                    bQ = new BigDecimal(((r[1] == null) ? 0.0 : (double) r[1]));
                                    rQa = bd.divide(bQ, 4, RoundingMode.HALF_EVEN);
                                    rrQa = Double.parseDouble(rQa.toString());

                                    addSubStorInventoryPos(((r1[5] == null) ? 0 : (int) r1[5]), ((r1[6] == null) ? 0 : (int) r1[6]), r1[4].toString(), refNo, bd.doubleValue(), ((r1[7] == null) ? "0" : (String) r1[7]), nightDate, userId, ((r1[8] == null) ? "" : (String) r1[8]), 1, bil, ((r1[9] == null) ? 0 : (int) r1[9]), invSubStore, ((r1[10] == null) ? 0 : (int) r1[10]), ((r1[11] == null) ? 0.0 : (double) r1[11]), ((r1[0] == null) ? "0" : (String) r1[0]));
                                    updateSubStoreInventory(((r1[6] == null) ? 0 : (int) r1[6]), bd1.doubleValue());

                                    isFinance = posDao.isFinance();
                                    if (isFinance) {
                                        if (posDao.isIteCon(cat2, invSubStore) > 0) {
                                            financeDao.addFinancePosting(bil, ((r1[0] == null) ? "0" : (String) r1[0]), ((r1[7] == null) ? "0" : (String) r1[7]), invSubStore, bd.doubleValue(), nightDate, userId, ((r[1] == null) ? 0.0 : (double) r1[1]) + "", ((r1[6] == null) ? 0 : (int) r1[6]) + "", rrQa, cat2);
                                        }
                                    }
                                    break;
                                } else {
                                    BigDecimal bd1 = new BigDecimal(((r1[1] == null) ? 0.0 : (double) r1[1]));
                                    bd1 = bd1.subtract(new BigDecimal(String.valueOf(bd.doubleValue())));
                                    bQ = new BigDecimal(((r[1] == null) ? 0.0 : (double) r[1]));
                                    if (bQ.doubleValue() != 0.0) {
                                        rQa = bd.divide(bQ, 4, RoundingMode.HALF_EVEN);
                                    } else {
                                        rQa = bd;
                                    }
                                    rrQa = Double.parseDouble(rQa.toString());

                                    addSubStorInventoryPos(((r1[5] == null) ? 0 : (int) r1[5]), ((r1[6] == null) ? 0 : (int) r1[6]), r1[4].toString(), refNo, bd.doubleValue(), ((r1[7] == null) ? "0" : (String) r1[7]), nightDate, userId, ((r1[8] == null) ? "" : (String) r1[8]), 1, bil, ((r1[9] == null) ? 0 : (int) r1[9]), invSubStore, ((r1[10] == null) ? 0 : (int) r1[10]), ((r1[11] == null) ? 0.0 : (double) r1[11]), ((r1[0] == null) ? "0" : (String) r1[0]));
                                    updateSubStoreInventory((int) r1[6], bd1.doubleValue());

                                    isFinance = posDao.isFinance();
                                    if (isFinance) {
                                        if (posDao.isIteCon(cat2, invSubStore) > 0) {
                                            financeDao.addFinancePosting(bil, ((r1[0] == null) ? "0" : (String) r1[0]), ((r1[7] == null) ? "0" : (String) r1[7]), invSubStore, bd.doubleValue(), nightDate, userId, ((r[1] == null) ? 0.0 : (double) r1[1]) + "", ((r1[6] == null) ? 0 : (int) r1[6]) + "", rrQa, cat2);
                                        }
                                    }
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        } finally {
                            if (bd.doubleValue() > 0) {
                                int binNo = getBinNo((String) r[0]);
                                String rBCode = getRefCodePos();
                                double oQ = -1 * bd.doubleValue();
                                for (Object[] r1 : rs1) {
                                    addSubStorInventoryPos(binNo, 0, "0000-00-00", refNo, oQ, (String) r[0], nightDate, userId, rBCode, 1, bil, ((r1[9] == null) ? 0 : (int) r1[9]), invSubStore, (int) r1[10], (double) r1[11], (String) r1[0]);
                                }
                            }
                        }

                    } else {
                        int binNo = getBinNo((String) r[0]);
                        String rBCode = getRefCodePos();
                        double oQ = -1 * bd.doubleValue();
                        for (Object[] r1 : rs1) {
                            addSubStorInventoryPos(binNo, 0, "0000-00-00", refNo, oQ, (String) r[0], nightDate, userId, rBCode, 1, bil, (int) r1[9], invSubStore, (int) r1[10], (double) r1[11], (String) r1[0]);
                        }
                    }
                }
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    private Integer getItemCat2No(String itemCode) {
        int cat2No = 0;
        try {
            Query hql = getInventorySession().createQuery("select cat2No from Item where iteNo=:itemCode").setString("itemCode", itemCode);
            List rs = hql.list();
            if (!rs.isEmpty()) {
                cat2No = (int) (double) rs.get(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat2No;

    }
}
