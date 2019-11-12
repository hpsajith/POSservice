package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.*;
import com.ites.poswebservice.model.random.OpenedBillDetails;
import com.ites.poswebservice.model.random.OpenedBillItemList;
import com.ites.poswebservice.model.random.SettlementDetails;
import com.ites.poswebservice.model.reservation.HouseAccount;
import com.ites.poswebservice.report.GetReport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.json.JSONObject;

/**
 * Created by wannix on 1/18/17.
 */
public class PosDaoImpl implements PosDao {

    private int discountNo = 6;

    @Autowired
    private SessionFactory sessionFactoryHotelPos;

    @Autowired
    private ReservationDao reservationDao;

    public Session getPOSSession() {
        return sessionFactoryHotelPos.openSession();
    }

    @Autowired
    private SessionFactory sessionFactoryReservation;

    public Session getResSession() {
        return sessionFactoryReservation.openSession();
    }

    @Override
    public List<Object[]> getTaxCalcResultSet(int taxId, boolean flag) {
        Query hql;
        if (flag) {
            hql = getPOSSession().createQuery("select tc.taxNo, t.taxCalculateValue from TaxClassTaxes tc, Tax t where tc.taxNo = t.taxNo and tc.taxClassNo = :taxId and t.taxNo = 1").setInteger("taxId", taxId);
        } else {
            hql = getPOSSession().createQuery("select tc.taxNo, t.taxCalculateValue from TaxClassTaxes tc, Tax t where tc.taxNo = t.taxNo and tc.taxClassNo = :taxId").setInteger("taxId", taxId);
        }

        List<Object[]> rs = hql.list();

        return rs;
    }

    @Override
    public int getBillFormat() {
        int billformat = 1;
        try {
            Query hql = getPOSSession().createQuery("select billFormat from Company");
            List<Integer> rs = hql.list();
            for (Integer r : rs) {
                billformat = r;
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return billformat;
    }

    @Override
    public boolean financePostingPos(String code, String chAccC, String chAccD, BigDecimal issPrice, BigDecimal cdAmt, String refNo, String itemNo, int subDepNo, Double amt, String date, int uId) {
        boolean flag = false;

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
        try {
            ip1.setDate(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ip1.setUserId(uId);
        ip1.setPostingType("S");
        ip1.setItemNo(itemNo);
        ip1.setQty(amt);
        ip1.setIssPrice(issPrice.doubleValue());

        Inventoryposting ip2 = new Inventoryposting();
        ip2.setReferenceNo(refNo);
        ip2.setAccountNo(chAccD);
        ip2.setSubDeptNo(subDepNo);
        ip2.setDescription(code);
        ip2.setCreditDebit(1);
        ip2.setAmount(cdAmt.doubleValue());
        ip2.setcAmount(cdAmt.doubleValue());
        ip2.setdAmount(0.0);
        try {
            ip2.setDate(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ip2.setUserId(uId);
        ip2.setPostingType("S");
        ip2.setItemNo(itemNo);
        ip2.setQty(amt);
        ip2.setIssPrice(issPrice.doubleValue());

        try {
            Session session = getPOSSession();
            session.save(ip1);
            session.close();

            Session session2 = getPOSSession();
            session2.save(ip2);
            session2.close();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return flag;
    }

    @Override
    public double getRate(String itemCode, int rateType) {
        double rate = 0;
        int rateNo = 1;
        rateNo = rateType;

        Query hql = getPOSSession().createQuery("from MItemRate ir, MItem i where ir.itemNo = i.itemCode and i.itemCode=:itemCode and ir.rateNo=:rateNo").setString("itemCode", itemCode).setInteger("rateNo", rateNo);
        List<Object[]> rs = hql.list();

        for (Object[] r : rs) {
            rate = ((MItemRate) r[0]).getRateValue();
        }
        rs = null;

        return rate;
    }

    @Override
    public double getRateTax(String itemCode, int rateType) {
        double rate = 0;
        int rateNo = 1;
        rateNo = rateType;

        Query hql = getPOSSession().createQuery("select rateValue from MItemRate where itemNo=:itemCode and rateNo=:rateNo").setString("itemCode", itemCode).setInteger("rateNo", rateNo);
        List rs = hql.list();

        for (Object r : rs) {
            rate = (double) r;
        }
        rs = null;

        return rate;
    }

    @Override
    public String getUnit(String itemCode) {
        String unit = "";
        Query hql = getPOSSession().createQuery("select iu.uName from MItemUnit iu, MItem i where i.unitNo = iu.uNo and i.itemCode=:itemCode").setString("itemCode", itemCode);
        List rs = hql.list();

        for (Object r : rs) {
            unit = (String) r;
        }
        rs = null;

        return unit;
    }

    @Override
    public String getChOfItemExp(int dep, int c, int cat2) {
        String chVal = "";
        try {
            Query hql = getPOSSession().createQuery("from ConfigBvgCoa where subDep=:dep and enType=:c and invCat2No=:cat2").setInteger("dep", dep).setInteger("c", c).setInteger("cat2", cat2);
            List<ConfigBvgCoa> rs = hql.list();
            for (ConfigBvgCoa r : rs) {
                chVal = r.getAdChartOfAcc();
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return chVal;
    }

    @Override
    public boolean isFinance() {
        int val = 0;
        try {
            Query hql = getPOSSession().createQuery("from MCheckFinance where checkFinance=1");
            List<MCheckFinance> rs = hql.list();
            val = rs.get(0).getCheckFinance();
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (val == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int isIteCon(int ite, int subDep) {
        int val = 0;
        try {
            Query hql = getPOSSession().createQuery("select count(*) from ConfigItemCoa where cat2No=:ite and subDep=:subDep").setInteger("ite", ite).setInteger("subDep", subDep);
            List<Long> rs = hql.list();
            for (Long r : rs) {
                val = r.intValue();
            }

            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return val;
    }

    @Override
    public int getInvSubStore(int itemCode, String subItemCode, int restId) {
        int IDp = 0;
        try {
//            Query hql = getPOSSession().createQuery("from MItemCost m inner join ConfigRestrntSubstore c on (m.invOutlet = c.invSubstore) where m.mainItemCode = :itemCode and m.subItemCode=:subItemCode and c.restuarantId=:restId group by m.invOutlet").setInteger("itemCode", itemCode).setString("subItemCode", subItemCode).setInteger("restId", restId);
            Query hql = getPOSSession().createQuery("from MItemCost m, ConfigRestrntSubstore c where m.invOutlet = c.invSubstore and m.mainItemCode = :itemCode and m.subItemCode=:subItemCode and c.restuarantId=:restId group by m.invOutlet").setInteger("itemCode", itemCode).setString("subItemCode", subItemCode).setInteger("restId", restId);
            List<Object[]> rs = hql.list();
            if (!rs.isEmpty()) {
                IDp = (((MItemCost) rs.get(0)[0]).getInvOutlet());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return IDp;
    }

    @Override
    public int updateStates(FrontPosguest frontPosguest) {
        Session session = getPOSSession();
        Query query = session.createQuery("update FrontPosguest set states = :sta" + " where posGuestno = :posGuestNo");
        query.setParameter("sta", 1);
        query.setParameter("posGuestNo", frontPosguest.getPosGuestno());
        int result = query.executeUpdate();
        return result;
    }

    @Override
    public double getExchangeRate(int ItemCode) {
        double rate;
        int curencyId = 1;

        Query hql1 = getPOSSession().createQuery("select m.currencyId from MItemRate m "
                + "where m.itemNo=:itemCode").setParameter("itemCode", ItemCode);
        curencyId = (int) hql1.list().get(0);

        rate = reservationDao.getSellingPrice(curencyId);

        return rate;
    }

    @Override
    public boolean isInventory() {
        Query hql = getPOSSession().createQuery("select m.checkInventry from MCheckInventry m where m.checkInventry=1");

        if ((int) hql.list().get(0) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insertKotBotMenu(int menuId, int kotId, int isSetMenu, int setMenuNo) {
        boolean flag = false;
        try {
            FrontKotBotMenu obj = new FrontKotBotMenu();
//            obj.setMenuId(menuId);
            obj.setKotBotNo(kotId);
            obj.setIsSetmenu(isSetMenu);
            obj.setSetMenuNo(setMenuNo);
            Session session2 = getPOSSession();
            session2.save(obj);
            session2.close();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public int insertKotBotItemAb(int kotNo, int itemCode, int taxId, double unitPrice, int qty, double roundRate, int guestState, String itemComment) {
        int No = 0;
        try {
            Query hql = getPOSSession().createQuery("from MItem  where itemCode=:itemCode").setInteger("itemCode", itemCode);
            List<MItem> rs = hql.list();

            for (MItem r : rs) {
                String itemCost = getItemCost(r.getItemCode());
                int isSetMenu = r.getIsSetmenu();
                int menuNo = getkotBotMenuNo();
                int setMenuNo = 0;
                if (isSetMenu != 0) {
                    Query hql1 = getPOSSession().createQuery("from MItemMenu where menuItemNo=:itemCode").setInteger("itemCode", itemCode);
                    List<MItemMenu> rs1 = hql1.list();

                    boolean val = false;
                    if (!rs1.isEmpty()) {
                        val = insertKotBotMenu(menuNo, kotNo, isSetMenu, (rs1.get(0)).getMenuItemNo());
                        No = insertKotBotItem(kotNo, menuNo, itemCode, taxId, unitPrice, qty, 0, Double.parseDouble(itemCost), roundRate, itemComment);
                    }
                    if (val) {
                        for (MItemMenu r1 : rs1) {
                            insertKotBotItem(kotNo, menuNo, r1.getItemNo(), taxId, getRate(r1.getItemNo() + "", guestState), qty, 1, Double.parseDouble(itemCost), roundRate, itemComment);
                        }
                    }
                    rs1 = null;
                } else {
                    boolean val = insertKotBotMenu(menuNo, kotNo, isSetMenu, setMenuNo);
                    if (val) {
                        No = insertKotBotItem(kotNo, menuNo, itemCode, taxId, unitPrice, qty, 0, Double.parseDouble(itemCost), roundRate, itemComment);
                    }
                }
            }
            rs = null;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return No;
    }

    private boolean kotIsTax(String kotId) {
        boolean flag = false;
        try {
            Query hql = getPOSSession().createQuery("from FrontKotBotMain fm, FrontPosguest fg where fg.posGuestno=fm.posGuestno and fm.kotNo=:kotId and fg.isTax=0").setInteger("kotId", Integer.parseInt(kotId));
            List<Object[]> rs = hql.list();
            flag = !rs.isEmpty();
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return flag;
    }

    private int insertKotBotItem(int kotNo, int menuId, int itemCode, int taxId, double unitPrice, int qty, int setMenu, double itemCost, double unitPriceTax, String itemComment) {
        int flag = 0;
        try {
            FrontKotBotItem obj = new FrontKotBotItem();
            obj.setKotBotNo(kotNo);
            obj.setMenuId(menuId);
            obj.setItemCode(itemCode);
            obj.setTaxClass(taxId);
            obj.setUnitPrices(unitPrice);
            obj.setQty(qty / 1.0);
            obj.setIsSetMenu(setMenu);
            obj.setOrderTime(new Date());
            obj.setUnitCost(itemCost);
            obj.setItemcomment(itemComment);
            obj.setUnitpriceswithTax(unitPriceTax);

            Session session2 = getPOSSession();
            session2.save(obj);
            session2.close();

            int itemNo = getKotBotItemNo();
            if (kotIsTax(kotNo + "")) {
                insertKotBotTaxSC(itemNo, taxId, unitPrice, qty);
            } else {
                insertKotBotTax(itemNo, taxId, unitPrice, qty);
            }

            flag = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public void insertKotBotTax(int itemNo, int taxId, double unitPrice, int qty) {
        try {
            List<Object[]> rs = getTaxCalcResultSet(taxId, false);

            Query hql = getPOSSession().createQuery("select f.unitpriceswithTax from FrontKotBotItem f where f.itemNo = :itemNo").setInteger("itemNo", itemNo);
            List rs2 = hql.list();

            BigDecimal roundPrice = new BigDecimal((rs2.isEmpty()) ? 0.0 : (double) rs2.get(0));
            roundPrice = roundPrice.multiply(new BigDecimal(qty));

            BigDecimal totalTax2 = new BigDecimal("0");
            int lastTaxNo = 0;
            String value = "0";

            for (Object[] r : rs) {
                BigDecimal bd = new BigDecimal((Double) r[1]);
                bd = bd.multiply(new BigDecimal(unitPrice));
                bd = bd.multiply(new BigDecimal(qty));

                value = this.twoDigits(bd.doubleValue());
                BigDecimal totalTax = new BigDecimal(value);
                totalTax2 = totalTax2.add(totalTax);

                try {
                    FrontKotBotTax fkbt = new FrontKotBotTax();
                    fkbt.setKBItemNo(itemNo);
                    lastTaxNo = (int) r[0];
                    fkbt.setTaxNo(lastTaxNo);
                    fkbt.setTaxAmount(Double.valueOf(value));
                    Session session2 = getPOSSession();
                    session2.save(fkbt);
                    session2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            roundPrice = (roundPrice.subtract(totalTax2)).subtract(new BigDecimal(unitPrice).multiply(new BigDecimal(qty)));
            if (!roundPrice.equals(new BigDecimal("0.0")) & !(roundPrice.doubleValue() < 0) & (roundPrice.doubleValue() < 1)) {
                roundPrice = (new BigDecimal(value)).add(roundPrice);

                FrontKotBotTax fkbt = new FrontKotBotTax();
                fkbt.setKBItemNo(itemNo);
                fkbt.setTaxNo(lastTaxNo);
                fkbt.setTaxAmount(roundPrice.doubleValue());

                try {
                    Session session3 = getPOSSession();
                    session3.update(fkbt);
                    session3.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertKotBotTaxSC(int itemNo, int taxId, double unitPrice, int qty) {
        try {
            List<Object[]> rs = getTaxCalcResultSet(taxId, true);

            for (Object[] r : rs) {
                BigDecimal bd = new BigDecimal((double) r[1]);
                bd = bd.multiply(new BigDecimal(unitPrice));
                bd = bd.multiply(new BigDecimal(qty));

                String value = this.twoDigits(bd.doubleValue());

                try {
                    FrontKotBotTax fkbt = new FrontKotBotTax();
                    fkbt.setKBItemNo(itemNo);
                    fkbt.setTaxNo(1);
                    fkbt.setTaxAmount(Double.valueOf(value));
                    Session session2 = getPOSSession();
                    session2.save(fkbt);
                    session2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean finishKotBotMenus(int kotId, int guestNo, int userId, int guestState, int restaurantNo) {
        boolean bool = false;

        FrontPosguest fpg = new FrontPosguest();
        fpg.setStates(1);
        fpg.setPosGuestno(guestNo);

        FrontKotBotMain fkbm = new FrontKotBotMain();
        fkbm.setIsEnter(1);
        fkbm.setKotNo(kotId);

        try {
            Session session1 = getPOSSession();
            session1.update(fpg);
            session1.close();
            Session session2 = getPOSSession();
            session2.update(fkbm);
            session2.close();

            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        insertkotBotDiscount(userId, kotId, guestState, restaurantNo);
        return bool;
    }

    @Override
    public void updateStatusPos(int kotId) {
        try {
            FrontKotBotMain fkbm = new FrontKotBotMain();
            fkbm.setKotNo(kotId);
            fkbm.setIsEnter(0);
            getPOSSession().update(fkbm);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean insertKotBotItemTemp(int kotId, int itemCode, int qty, int type, int printer) {
        boolean flag = false;
        try {
            FrontKotItemTemp fkit = new FrontKotItemTemp();
            fkit.setKotNo(kotId);
            fkit.setItemCode(itemCode);
            fkit.setQty(qty);
            fkit.setType(type);
            fkit.setPrinter(printer);

            Session session = getPOSSession();
            session.save(fkit);

            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        kotId = 0;
        itemCode = 0;
        qty = 0;
        return flag;
    }

    @Override
    public List<Object[]> getSubItems(int itemCode) {
        Query hql = getPOSSession().createQuery("select ic.subItemCode, sum(ic.itemQuantity) as qty, gf.department from MGroupFamily gf, MItem i, MItemCost ic where (i.familyGno = gf.fno) and (ic.mainItemCode = i.itemCode) and i.itemCode=:itemCode and ic.subItemCode != '0' group by ic.subItemCode").setInteger("itemCode", itemCode);
        List<Object[]> rs = hql.list();

        return rs;
    }

    @Override
    public void tempItem(int kotId, int restId, String resourcePath, String subreportPath) {
        try {
            Query hql = getPOSSession().createQuery("select f.itemCode, f.qty from FrontKotBotItem f,MItem m where f.itemCode=m.itemCode and f.kotBotNo=:kotId and m.isSetmenu = 0 and m.printer=1").setInteger("kotId", kotId);
            List<Object[]> rs = hql.list();
            boolean flag = false;
            for (Object[] r : rs) {
                flag = true;
                insertKotBotItemTemp(kotId, (int) r[0], ((Double) r[1]).intValue(), 1, 1);
            }
            if (flag) {
                GetReport t = new GetReport(restId, kotId, "1", "2", "3", "4", "Item", "Item", "Void Item", "Void Item", 1, resourcePath, subreportPath);
                t.generateReport();
            }

            Query hql1 = getPOSSession().createQuery("select f.itemCode, f.qty from FrontKotBotItem f, MItem m where f.itemCode=m.itemCode and f.kotBotNo=:kotId and m.isSetmenu = 0 and m.printer=2").setInteger("kotId", kotId);
            List<Object[]> rs1 = hql1.list();
            boolean flag1 = false;
            for (Object[] r1 : rs1) {
                flag1 = true;
                insertKotBotItemTemp(kotId, (int) r1[0], ((Double) r1[1]).intValue(), 1, 2);
            }
            if (flag1) {
                GetReport t = new GetReport(restId, kotId, "1", "2", "3", "4", "Item", "Item", "Void Item", "Void Item", 2, resourcePath, subreportPath);
                t.generateReport();
            }

            Query hql2 = getPOSSession().createQuery("select f.itemCode, f.qty from FrontKotBotItem f, MItem m where f.itemCode=m.itemCode and f.kotBotNo=:kotId and m.isSetmenu = 0 and m.printer=3").setInteger("kotId", kotId);
            List<Object[]> rs2 = hql2.list();

            boolean flag2 = false;
            for (Object[] r2 : rs2) {
                flag2 = true;
                insertKotBotItemTemp(kotId, (int) r2[0], ((Double) r2[1]).intValue(), 1, 3);
            }
            if (flag2) {
                GetReport t = new GetReport(restId, kotId, "1", "2", "3", "4", "Item", "Item", "Void Item", "Void Item", 3, resourcePath, subreportPath);
                t.generateReport();
            }
            rs = null;
            rs1 = null;
            rs2 = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        kotId = 0;
    }

    private int getkotBotMenuNo() {
        int menuId = 0;
        Query hql = getPOSSession().createQuery("select max(menuId) as menuId from FrontKotBotMenu");
        List<Object> rs = hql.list();
        try {
            for (Object r : rs) {
                menuId = Integer.parseInt(r.toString());
            }
        } catch (Exception e) {
            menuId = 0;
            e.printStackTrace();
        }

        menuId++;
        rs = null;

        return menuId;
    }

    private String getItemCost(int itemCode) {
        String cost = "0";
        try {
            Query hql = getPOSSession().createQuery("from MItemCost where mainItemCode=:itemCode").setInteger("itemCode", itemCode);
            List<MItemCost> rs = hql.list();
            BigDecimal bd = new BigDecimal("0");
            for (MItemCost r : rs) {
                BigDecimal bd1 = new BigDecimal(r.getItemCost());
                bd1 = bd1.multiply(new BigDecimal(r.getItemQuantity()));
                bd = bd.add(bd1);
            }
            cost = twoDigits(bd.doubleValue());
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cost;
    }

    private void insertkotBotDiscount(int userId, int kotId, int guestState, int restaurantId) {
        try {
            boolean flag = false;
            Map<String, String> Account = new HashMap<>();
            Map<String, Double> price = new HashMap<>();
            List<String> list = new ArrayList<>();

            Query hql1 = getPOSSession().createQuery("select f.itemNo, f.itemCode, m.familyGno, sum(f.unitPrices*f.qty) as price, m.revenueType from FrontKotBotItem f, MItem m where m.itemCode = f.itemCode and f.kotBotNo = :kotId group by f.itemCode").setInteger("kotId", kotId);
            List<Object[]> set1 = hql1.list();

            for (Object[] r1 : set1) {
                BigDecimal discount = new BigDecimal("0");

                Query hql2 = getPOSSession().createQuery("select c.accountNo, c.disNo, c.disType, f.value from FrontKotBotDiscount f, ConfigDiscount c where c.disNo=f.disvountType and f.kotBotNo= :kotId and c.familyNo= :familyGno").setInteger("kotId", kotId).setInteger("familyGno", (int) r1[2]);
                List<Object[]> set2 = hql2.list();

                for (Object[] r2 : set2) {
                    flag = true;
                    if ((int) r2[3] == 1) {
                        BigDecimal value = new BigDecimal((double) r1[3]);
                        value = value.multiply(new BigDecimal((double) r2[3]));
                        value = value.divide(new BigDecimal("100"), MathContext.DECIMAL128);
                        discount = discount.add(value);
                        String disRevenue = r2[1] + "_" + r1[4] + "_" + r1[0];
                        if (Account.containsKey(disRevenue)) {
                            BigDecimal disPrice = new BigDecimal(price.get(disRevenue));
                            price.remove(disRevenue);
                            disPrice = disPrice.add(value);
                            price.put(disRevenue, disPrice.doubleValue());
                            disPrice = null;
                        } else {
                            list.add(disRevenue);
                            Account.put(disRevenue, (String) r2[0]);
                            price.put(disRevenue, value.doubleValue());
                        }
                        value = null;
                    } else {
                        discount = discount.add(new BigDecimal((double) r2[3]));
                        String disRevenue = r2[1] + "_" + r1[4];
                        if (Account.containsKey(disRevenue)) {
                            BigDecimal disPrice = new BigDecimal(price.get(r2[1]));
                            price.remove(disRevenue);
                            disPrice = disPrice.add(new BigDecimal(disRevenue));
                            price.put(disRevenue, disPrice.doubleValue());
                            disPrice = null;
                        } else {
                            list.add(disRevenue);
                            Account.put(disRevenue, (String) r2[0]);
                            price.put(disRevenue, (double) r2[3]);
                        }
                    }
                }
                set2 = null;
                BigDecimal taxPrice = new BigDecimal((double) r1[3]);
                taxPrice = taxPrice.subtract(discount);
                if (flag) {
                    if (guestState != 4) {
                        Query hql3 = getPOSSession().createQuery("select f.kBTaxNo,t.taxCalculateValue,f.taxAmount from FrontKotBotTax f, Tax t where f.taxNo=t.taxNo and f.kBItemNo= :itemNo").setInteger("itemNo", (int) r1[0]);
                        List<Object[]> set3 = hql3.list();

                        for (Object[] r3 : set3) {
                            BigDecimal taxValue = new BigDecimal(taxPrice.doubleValue());
                            taxValue = taxValue.multiply(new BigDecimal((double) r3[1]));
                            String value = this.twoDigits(taxValue.doubleValue());

                            FrontKotBotTax fkbt = new FrontKotBotTax();
                            fkbt.setKBTaxNo((int) r3[0]);
                            fkbt.setTaxAmount(Double.valueOf(value));

                            Session session = getPOSSession();
                            session.update(fkbt);
                            session.close();

                            taxValue = null;
                        }
                        set3 = null;
                    } else {
                        Query hql3 = getPOSSession().createQuery("select f.kBTaxNo,t.taxCalculateValue,f.taxAmount from FrontKotBotTax f, Tax t where f.taxNo = t.taxNo and f.kBItemNo= :itemNo").setInteger("itemNo", (int) r1[0]);
                        List<Object[]> set3 = hql3.list();

                        for (Object[] r3 : set3) {
                            BigDecimal taxValue = new BigDecimal(taxPrice.doubleValue());
                            taxValue = taxValue.multiply(new BigDecimal((double) r3[1]));
                            String value = this.twoDigits(taxValue.doubleValue());

                            FrontKotBotTax fkbt = new FrontKotBotTax();
                            fkbt.setKBTaxNo((int) r3[0]);
                            fkbt.setTaxAmount(Double.valueOf(value));

                            Session session2 = getPOSSession();
                            session2.update(fkbt);
                            session2.close();
                            taxValue = null;
                        }
                        set3 = null;
                    }
                    discount = null;
                    taxPrice = null;
                }
            }
            set1 = null;

            for (String DisNo : list) {
                String dis[] = DisNo.split("_");

                FrontPayment fp = new FrontPayment();
                fp.setPaymentType(discountNo);
                fp.setPaymentDate(new Date());
                fp.setPaymentAmount(BigDecimal.valueOf(price.get(DisNo)));
                fp.setKotNo(kotId);
                fp.setUserId(userId);
                fp.setAccountNo(Account.get(DisNo));
                fp.setDiscountNo(Integer.valueOf(dis[0]));
                fp.setResturentId(restaurantId);
                fp.setRevenueType(Integer.valueOf(dis[1]));
                fp.setItemNo(Integer.valueOf(dis[2]));

                Session session3 = getPOSSession();
                session3.save(fp);
                session3.close();
            }

            list = null;
            price = null;
            Account = null;
            kotId = 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String twoDigits(double val) {
        String val1;
        DecimalFormat nf = new DecimalFormat("#####0.00");
        val1 = nf.format(val);
        return val1;
    }

    private int getKotBotItemNo() {
        int menuId = 0;
        Query hql = getPOSSession().createQuery("select max(f.itemNo) from FrontKotBotItem f");
        menuId = (int) hql.list().get(0);

        menuId++;

        return menuId;
    }

    @Override
    public List<FrontKotBotItem> gerBeforeRawCount(int kotId) {
        List<FrontKotBotItem> itemList;
        Query hql = getPOSSession().createQuery(" from FrontKotBotItem where kotBotNo ='" + kotId + "'");
        itemList = (List<FrontKotBotItem>) hql.list();

        return itemList;
    }

    @Override
    public void updateKotBotItem(int kotNo, int itemCode, int itemQty, int guestState) {
//ResultSet rs = null;
        try {
            Query hql = getPOSSession().createQuery("select fkbi.itemNo,fkbi.itemCode,fkbi.qty,fkbm.isSetmenu,fkbi.menuId,fkbi.unitPrices,fkbi.unitpriceswithTax,fkbi.taxClass from FrontKotBotItem as fkbi,FrontKotBotMenu as fkbm where fkbi.menuId=fkbm.menuId and fkbi.kotBotNo ='" + kotNo + "' and fkbm.isSetmenu='0' and fkbi.itemCode='" + itemCode + "'");
            List<Object[]> rs = hql.list();
            for (int i = 0; i < rs.size(); i++) {
                int itemNo = (int) rs.get(i)[0];
                int itemCodee = (int) rs.get(i)[1];
                String itemCost = getItemCost(itemCodee);
                int isSetMenu = (int) rs.get(i)[3];
                int menuId = (int) rs.get(i)[4];
                double unitPrice = (Double) rs.get(i)[5];
                double unitPriceWithTax = (Double) rs.get(i)[6];
                int taxClass = (int) rs.get(i)[7];
                if (isSetMenu != 0) {
//                        ResultSet rs1 = (ResultSet) db.fetch("select * from front_kot_bot_item where menu_id='" + rs.getString("front_kot_bot_item.menu_id") + "'");
                    Query hql2 = getPOSSession().createQuery("from FrontKotBotItem as fki where fki.menuId ='" + menuId + "' ");
                    List<FrontKotBotItem> itemList = hql2.list();
                    for (int j = 0; j < itemList.size(); j++) {
//                            updateKotBotItem(kotid, Integer.parseInt(qty), rs1.getInt("item_no"), rs1.getDouble("unit_prices"), rs1.getInt("tax_class"), itemCost, guestState);
                        updateKotBotItem(kotNo, itemQty, itemList.get(j).getItemNo(), itemList.get(j).getUnitPrices(), itemList.get(j).getUnitpriceswithTax(), itemList.get(j).getTaxClass(), itemCost, guestState);
                    }
                } else {
                    updateKotBotItem(kotNo, itemQty, itemNo, unitPrice, unitPriceWithTax, taxClass, itemCost, guestState);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getPosRestDescription(int kotNo) {
        String x = "";
        try {
            Query hql = getPOSSession().createQuery("from MRestaurantRoom m where m.rno=(select f.resRoom from FrontKotBotMain f where f.kotNo=:kotNo)").setInteger("kotNo", kotNo);
            List<MRestaurantRoom> rs = hql.list();
            for (MRestaurantRoom r : rs) {
                x = r.getDescription();
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return x;
    }

    @Override
    public int getfbsId(int kotNo) {
        int x = 0;
        try {
            Query hql = getPOSSession().createQuery("from FrontBillSplit f where f.kotNo=:kotNo").setInteger("kotNo", kotNo);
            List<FrontBillSplit> rs = hql.list();

            for (FrontBillSplit r : rs) {
                x = r.getFbsId();
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return x;
    }

    @Override
    public String getbillNumber(String kotNo, String dis, int splitKotId, int userId) {
        String billNumber = "";
        int x = hasKotSplit(Integer.valueOf(kotNo));

        if (x == 1) {
            try {
                Query hql = getPOSSession().createQuery("select nullif(max(f.intBillNo), 0) from FrontBillSplit f where f.billNo like :dis% and f.kotNo=:kotNo").setString("dis", dis).setString("kotNo", kotNo);
                List rs = hql.list();
                if (!rs.isEmpty()) {
                    billNumber = (String) rs.get(0);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Query hql = getPOSSession().createQuery("from FrontKotBotMain f where f.kotNo=:kotNo").setString("kotNo", kotNo);
                List<FrontKotBotMain> rs = hql.list();
                if (!rs.isEmpty()) {
                    billNumber = rs.get(0).getBillNo();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String restaurant = dis;
        String maxBill = "0";
        int maxBill1Int = 1;
        String newBill = "";

        if (billNumber.equalsIgnoreCase("0")) {
            try {
                Query hql = getPOSSession().createQuery("select max(f.intBillNo) from FrontKotBotMain f where f.billNo like '" + dis + "%'");
                List rs = hql.list();
                if (!rs.isEmpty()) {
                    maxBill1Int = (rs.get(0) != null) ? (int) rs.get(0) : 0;
                }
                maxBill1Int = maxBill1Int + 1;
                newBill = String.valueOf(maxBill).substring(1);
                newBill = restaurant + maxBill1Int;
            } catch (Exception e) {
                e.printStackTrace();
            }

            Date d1 = new Date();

            try {
                Query hql2 = getPOSSession().createQuery("from FrontKotBotMain f where f.kotNo=:kotNo").setString("kotNo", kotNo);
                FrontKotBotMain fkbm = (FrontKotBotMain) hql2.uniqueResult();
                fkbm.setBillNo(newBill);
                fkbm.setIntBillNo(maxBill1Int);
                fkbm.setPrintUser(userId);
                fkbm.setPrintTime(d1);

                Session session = getPOSSession();
                session.beginTransaction();
                session.update(fkbm);
                session.getTransaction().commit();
                session.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (x == 0) {
                try {
                    Query hql = getPOSSession().createQuery("select f.fbsId from FrontBillSplit f where f.kotNo=:kotNo").setString("kotNo", kotNo);
                    List<Integer> rs = hql.list();

                    int fbsId = 0;
                    if (!rs.isEmpty()) {
                        fbsId = rs.get(0);
                    }

                    Query hql3 = getPOSSession().createQuery("from FrontBillSplit f where f.fbsId=:fbsId").setInteger("fbsId", fbsId);
                    FrontBillSplit fbs = (FrontBillSplit) hql3.uniqueResult();
                    fbs.setKotNo(Integer.valueOf(kotNo));
                    fbs.setBillNo(newBill);
                    fbs.setIntBillNo(maxBill1Int);
                    fbs.setBillTime(d1);

                    Session session1 = getPOSSession();
                    session1.beginTransaction();
                    session1.update(fbs);
                    session1.getTransaction().commit();
                    session1.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (x == 1) {
                newBill = newBill + "_1";
                try {
                    Query hql4 = getPOSSession().createQuery("from FrontBillSplit f where f.fbsId=:fbsId and f.kotNo=:kotNo").setInteger("fbsId", splitKotId).setString("kotNo", kotNo);
                    FrontBillSplit fbs2 = (FrontBillSplit) hql4.uniqueResult();
                    fbs2.setBillNo(newBill);
                    fbs2.setBillTime(d1);
                    fbs2.setIntBillNo(1);

                    Session session2 = getPOSSession();
                    session2.beginTransaction();
                    session2.update(fbs2);
                    session2.getTransaction().commit();
                    session2.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return newBill;
        } else if (x == 1) {
            try {
                Query hql = getPOSSession().createQuery("select f.billNo from FrontBillSplit f where f.fbsId=:splitKotId").setInteger("splitKotId", splitKotId);
                List<String> rs = hql.list();
                if (!rs.isEmpty()) {
                    billNumber = rs.get(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String maxBill_no = null;
            if (billNumber.equalsIgnoreCase("0")) {
                try {
                    Query hql = getPOSSession().createQuery("from FrontBillSplit where kotNo=:kotNo order by intBillNo desc").setString("kotNo", kotNo);
                    List<FrontBillSplit> rs = hql.list();
                    if (!rs.isEmpty()) {
                        maxBill1Int = Integer.valueOf(rs.get(0).getIntBillNo());
                        maxBill_no = rs.get(0).getBillNo();
                    }
                    maxBill1Int = maxBill1Int + 1;
                    String maxBill_no1[] = maxBill_no.split("_");
                    newBill = maxBill_no1[0].toString() + "_" + maxBill1Int;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Date d1 = new Date();

                try {
                    Query hql3 = getPOSSession().createQuery("from FrontBillSplit f where f.fbsId=:fbsId and f.kotNo=:kotNo").setInteger("fbsId", splitKotId).setString("kotNo", kotNo);
                    FrontBillSplit fbs = (FrontBillSplit) hql3.uniqueResult();
                    fbs.setKotNo(Integer.valueOf(kotNo));
                    fbs.setBillNo(newBill);
                    fbs.setIntBillNo(maxBill1Int);
                    fbs.setBillTime(d1);

                    Session session4 = getPOSSession();
                    session4.beginTransaction();
                    session4.update(fbs);
                    session4.getTransaction().commit();
                    session4.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return newBill;
            } else {
                return billNumber;
            }
        } else {
            return billNumber;
        }

    }

    private int hasKotSplit(int kotNo) {
        int x = 0;
        try {
            Query hql = getPOSSession().createQuery("select f.hasSplit from FrontKotBotMain f where f.kotNo=:kotNo").setInteger("kotNo", kotNo);
            List<Boolean> rs = hql.list();
            for (Boolean r : rs) {
                if (r) {
                    x = 1;
                } else {
                    x = 0;
                }
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return x;
        }
        return x;
    }

    @Override
    public InputStream getCompanyLogo() {
        InputStream logo = null;
        try {
            Query hql = getPOSSession().createQuery("from Company");
            List<Company> rs = hql.list();
            for (Company r : rs) {
                logo = new ByteArrayInputStream(r.getLogo());
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return logo;
    }

    @Override
    public String getRestRoom(int kotNo) {
        String x = "";
        try {
            Query hql = getPOSSession().createQuery("from MRestaurantRoom where rNo=(select resRoom from FrontKotBotMain where kotNo=:kotNo)").setInteger("kotNo", kotNo);
            List<MRestaurantRoom> rs = hql.list();

            for (MRestaurantRoom r : rs) {
                x = r.getRname();
            }
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return x;
    }

    @Override
    public void deletetempItem(int kotNo) {
        Query hql = getPOSSession().createQuery("from FrontKotItemTemp where kotNo ='" + kotNo + "'");
        List<FrontKotItemTemp> rs = hql.list();
        for (int i = 0; i < rs.size(); i++) {
            FrontKotItemTemp fkit = rs.get(i);
//            getPOSSession().delete(fkit);
            Session session = getPOSSession();
            session.beginTransaction();
            session.delete(fkit);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<Object[]> getFrontKotBotItem(int kotNo, int printer) {
        Query hql = getPOSSession().createQuery("select fkbi.itemCode,fkbi.qty from FrontKotBotItem as fkbi,MItem as mi where fkbi.itemCode=mi.itemCode and fkbi.kotBotNo ='" + kotNo + "' and mi.printer='" + printer + "'");
        List<Object[]> rs = hql.list();
        return rs;
    }

    @Override
    public void insertKotBotitemTemp(int kotNo, int itemCode, int qty, int typ, int printer) {
        try {
            FrontKotItemTemp fkit = new FrontKotItemTemp();
            fkit.setKotNo(kotNo);
            fkit.setItemCode(itemCode);
            fkit.setQty(qty);
            fkit.setType(typ);
            fkit.setPrinter(printer);

            Session session = getPOSSession();
            session.saveOrUpdate(fkit);
            session.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertVoidItem(int kotNo, int itemCode, int voidQty, int voidRes, JSONObject orderDetails) {
        int userId = orderDetails.getInt("waiterId");
        int restaurantNo = orderDetails.getInt("restId");
        Date currDat = new Date();
        try {
            FrontKotBotItemVoid fkiv = new FrontKotBotItemVoid();
            fkiv.setKotNo(kotNo);
            fkiv.setItemNo(itemCode);
            fkiv.setQty(voidQty);
            fkiv.setVoidNo(voidRes);
            fkiv.setUserId(userId);
            fkiv.setResturentId(restaurantNo);
            fkiv.setSystemDate(currDat);
            Session session = getPOSSession();
            session.saveOrUpdate(fkiv);
            session.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int itemPrinter(String itemCode) {
        int printerId = 0;
        try {
            Query hql = getPOSSession().createQuery("select mi.printer from MItem as mi where mi.itemCode='" + itemCode + "'");
            Object obj = hql.uniqueResult();
            printerId = Integer.parseInt(obj.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return printerId;
    }

    @Override
    public List<MVoidReason> getVoidReason() {
        List<MVoidReason> voidReason = null;
        try {
            Query hql = getPOSSession().createQuery("from MVoidReason");
            voidReason = hql.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return voidReason;
    }

    @Override
    public void deleteKotBotTax(int kotId, String ItemCode) {

        Query hql = getPOSSession().createQuery("from FrontKotBotTax as fkbt where fkbt.kBItemNo in (select fkbi.itemNo from FrontKotBotItem as fkbi where fkbi.itemCode='" + ItemCode + "' and fkbi.kotBotNo='" + kotId + "' )");
        List<FrontKotBotTax> rs = hql.list();
        for (int i = 0; i < rs.size(); i++) {
            FrontKotBotTax fkbt = rs.get(i);
//            getPOSSession().delete(fkbt);
            Session session = getPOSSession();
            session.beginTransaction();
            session.delete(fkbt);
            session.getTransaction().commit();
            session.close();
        }
        Query hql1 = getPOSSession().createQuery("from FrontKotBotItem as fkbi where fkbi.itemCode='" + ItemCode + "' and fkbi.kotBotNo='" + kotId + "'");
        List<FrontKotBotItem> rs1 = hql1.list();
        for (int j = 0; j < rs1.size(); j++) {
            FrontKotBotItem fkbi = rs1.get(j);
            int menuId = fkbi.getMenuId();
            Query hql2 = getPOSSession().createQuery("from FrontKotBotMenu as fkbm where fkbm.menuId='" + menuId + "'");
            FrontKotBotMenu rs2 = (FrontKotBotMenu) hql2.uniqueResult();
//            getPOSSession().delete(rs2);
            Session session = getPOSSession();
            session.beginTransaction();
            session.delete(rs2);
            session.getTransaction().commit();
            session.close();
            Query hql3 = getPOSSession().createQuery("from FrontKotBotItem as fkbi where fkbi.menuId='" + menuId + "'");
            FrontKotBotItem rs3 = (FrontKotBotItem) hql3.uniqueResult();
//            getPOSSession().delete(rs3);
            Session session2 = getPOSSession();
            session2.beginTransaction();
            session2.delete(rs3);
            session2.getTransaction().commit();
            session2.close();
        }

    }

    @Override
    public void deactiveKot(int kotId) {
        Query hql = getPOSSession().createQuery("from FrontKotBotMain where kotNo='" + kotId + "'");
        FrontKotBotMain rs = (FrontKotBotMain) hql.uniqueResult();
        rs.setState(0);
        Session session2 = getPOSSession();
        session2.beginTransaction();
        session2.update(rs);
        session2.getTransaction().commit();
        session2.close();
    }

    private void updateKotBotItem(int kotNo, int itemQty, Integer itemNo, Double unitPrices, Double unitpriceswithTax, Integer taxClass, String itemCost, int guestState) {

//    String strSQL2 = "update front_kot_bot_item set QTY='" + QTY + "',unit_cost='" + unitCost + "' where item_no='" + ItemNo + "'";
        Query hql3 = getPOSSession().createQuery("from FrontKotBotItem as fkbi where fkbi.itemNo='" + itemNo + "'");
        FrontKotBotItem rs3 = (FrontKotBotItem) hql3.uniqueResult();
        String qty = itemQty + "";
        String cost = itemCost + "";
        rs3.setQty(new Double(qty));
        rs3.setUnitCost(new Double(cost));
        Session session2 = getPOSSession();
        session2.beginTransaction();
        session2.update(rs3);
        session2.getTransaction().commit();
        session2.close();

        if (kotIsTax(kotNo + "")) {
            updateKotBotTaxSC(itemNo, taxClass, unitPrices, itemQty);
        } else {
            updateKotBotTax(itemNo, taxClass, unitPrices, itemQty, unitpriceswithTax);
        }
    }

    private void updateKotBotTaxSC(Integer itemNo, Integer taxClass, Double unitPrices, int itemQty) {
        try {
            List<Object[]> rs = getTaxCalcResultSet(taxClass, true);

            for (Object[] r : rs) {
                BigDecimal bd = new BigDecimal((double) r[1]);
                bd = bd.multiply(new BigDecimal(unitPrices));
                bd = bd.multiply(new BigDecimal(itemQty));

                String value = this.twoDigits(bd.doubleValue());

                try {
                    FrontKotBotTax fkbt = new FrontKotBotTax();
                    fkbt.setKBItemNo(itemNo);
                    fkbt.setTaxNo(1);
                    fkbt.setTaxAmount(Double.valueOf(value));
                    Session session2 = getPOSSession();
                    session2.beginTransaction();
                    session2.saveOrUpdate(fkbt);
                    session2.getTransaction().commit();
                    session2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateKotBotTax(Integer itemNo, Integer taxClass, Double unitPrices, int itemQty, Double unitpriceswithTax) {
        try {
            BigDecimal roundPrice = new BigDecimal(unitpriceswithTax);
            roundPrice = roundPrice.multiply(new BigDecimal(String.valueOf(itemQty)));

            List<Object[]> rs = getTaxCalcResultSet(taxClass, false);
            BigDecimal totalTax2 = new BigDecimal("0");
            int lastTaxNo = 0;
            String value = "0";

            for (Object[] r : rs) {
                BigDecimal bd = new BigDecimal((Double) r[1]);
                bd = bd.multiply(new BigDecimal(unitPrices));
                bd = bd.multiply(new BigDecimal(itemQty));

                value = this.twoDigits(bd.doubleValue());
                BigDecimal totalTax = new BigDecimal(value);
                totalTax2 = totalTax2.add(totalTax);

                try {
                    FrontKotBotTax fkbt = new FrontKotBotTax();
                    fkbt.setKBItemNo(itemNo);
                    lastTaxNo = (int) r[0];
                    fkbt.setTaxNo(lastTaxNo);
                    fkbt.setTaxAmount(Double.valueOf(value));
                    Session session2 = getPOSSession();
                    session2.beginTransaction();
                    session2.saveOrUpdate(fkbt);
                    session2.getTransaction().commit();
                    session2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            roundPrice = (roundPrice.subtract(totalTax2)).subtract(new BigDecimal(unitPrices).multiply(new BigDecimal(itemQty)));
            if (!roundPrice.equals(new BigDecimal("0.0")) & !(roundPrice.doubleValue() < 0) & (roundPrice.doubleValue() < 1)) {
                roundPrice = (new BigDecimal(value)).add(roundPrice);

                FrontKotBotTax fkbt = new FrontKotBotTax();
                fkbt.setKBItemNo(itemNo);
                fkbt.setTaxNo(lastTaxNo);
                fkbt.setTaxAmount(roundPrice.doubleValue());

                try {
                    Session session2 = getPOSSession();
                    session2.beginTransaction();
                    session2.saveOrUpdate(fkbt);
                    session2.getTransaction().commit();
                    session2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteKotBotMenus(int kotId) {
        boolean bln = false;
        Query hql = getPOSSession().createQuery("from FrontKotBotTax as fkbt where fkbt.kBItemNo in (select fkbi.itemNo from FrontKotBotItem as fkbi where fkbi.kotBotNo='" + kotId + "' )");
        List<FrontKotBotTax> rs = hql.list();
        for (int i = 0; i < rs.size(); i++) {
            FrontKotBotTax fkbt = rs.get(i);
            Session session = getPOSSession();
            session.beginTransaction();
            session.delete(fkbt);
            session.getTransaction().commit();
            session.close();
        }
        Query hql3 = getPOSSession().createQuery("from FrontKotBotItem as fkbi where fkbi.kotBotNo='" + kotId + "'");

        List<FrontKotBotItem> rs3 = (List<FrontKotBotItem>) hql3.list();
        for (int j = 0; j < rs3.size(); j++) {
            FrontKotBotItem rst = rs3.get(j);
            Session session2 = getPOSSession();
            session2.beginTransaction();
            session2.delete(rst);
            session2.getTransaction().commit();
            session2.close();
        }
        Query hql2 = getPOSSession().createQuery("from FrontKotBotMenu as fkbm where fkbm.kotBotNo='" + kotId + "'");
        List<FrontKotBotMenu> rs2 = (List<FrontKotBotMenu>) hql2.list();
        for (int k = 0; k < rs2.size(); k++) {
            FrontKotBotMenu rstt = rs2.get(k);
            Session session = getPOSSession();
            session.beginTransaction();
            session.delete(rstt);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public OpenedBillDetails getBillDetails(int kotNo) {
        //SELECT front_kot_bot_item.unit_prices,front_kot_bot_item.Item_Code,SUM(front_kot_bot_item.QTY) AS QTY,m_item.item_name FROM front_posguest,front_kot_bot_main,m_item,front_kot_bot_item,front_bill_split WHERE front_kot_bot_item.kot_bot_no=front_kot_bot_main.kot_no AND  front_kot_bot_main.Pos_Guest_no=front_posguest.posGuest_no AND m_item.item_code=front_kot_bot_item.Item_Code AND front_kot_bot_main.kot_no= front_bill_split.kot_no AND  front_kot_bot_item.kot_bot_no ='1553' AND front_kot_bot_item.isSetMenu!=1  GROUP BY front_kot_bot_item.Item_Code
        //OpenedBillItemList(String itemName, int itemCode, double quantity, double unitPrice)
        Query hql2 = getPOSSession().createQuery(" select new com.ites.poswebservice.model.random.OpenedBillItemList(mit.itemName,fkit.itemCode,fkit.qty,fkit.unitPrices,mit.roundPrice)"
                + " from "
                + " FrontPosguest as fpg,"
                + " FrontKotBotMain as fkm,"
                + " MItem as mit,"
                + " FrontKotBotItem as fkit,"
                + " FrontBillSplit as fbs"
                + " where fkit.kotBotNo = fkm.kotNo"
                + " and fkm.posGuestno = fpg.posGuestno"
                + " and mit.itemCode = fkit.itemCode"
                + " and fkm.kotNo = fbs.kotNo"
                + " and fkit.kotBotNo = '" + kotNo + "'"
                + " and fkit.isSetMenu !='1' "
                + " group by fkit.itemCode");
        List<OpenedBillItemList> openedBillItemList = (List<OpenedBillItemList>) hql2.list();
        double totalWithoutTax = 0;
        for (int k = 0; k < openedBillItemList.size(); k++) {
            OpenedBillItemList rstt = openedBillItemList.get(k);
            totalWithoutTax = totalWithoutTax + (rstt.getUnitPrice() * rstt.getQuantity());
        }

        Query hql3 = getPOSSession().createQuery("select COALESCE(sum(fktx.taxAmount),0) as tax"
                + " from FrontKotBotTax as fktx"
                + " where fktx.kBItemNo in ( select fkbi.itemNo from FrontKotBotItem as fkbi where fkbi.kotBotNo ='" + kotNo + "' and fkbi.isSetMenu = '0') ");
        double totalTax = Double.parseDouble(hql3.uniqueResult().toString());

        Query hql4 = getPOSSession().createQuery("select COALESCE(sum(fp.paymentAmount),0) as payment"
                + " from FrontPayment as fp"
                + " where fp.kotNo = '" + kotNo + "' and fp.paymentType <> '6'");
        double totalPayment = Double.parseDouble(hql4.uniqueResult().toString());

        Query hql5 = getPOSSession().createQuery("select COALESCE(sum(fp.paymentAmount),0) as payment"
                + " from FrontPayment as fp"
                + " where fp.kotNo = '" + kotNo + "' and fp.paymentType = '6'");
        double totalDiscount = Double.parseDouble(hql5.uniqueResult().toString());

        OpenedBillDetails openedBillDetails = new OpenedBillDetails();
        openedBillDetails.setOpenedBillItemList(openedBillItemList);
        BigDecimal bd = new BigDecimal(totalWithoutTax);
        bd = bd.setScale(2, RoundingMode.HALF_EVEN);
        openedBillDetails.setTotalWithoutTax(bd.doubleValue());

        BigDecimal bd2 = new BigDecimal(totalTax);
        bd2 = bd2.setScale(2, RoundingMode.HALF_EVEN);
        openedBillDetails.setTotalTax(bd2.doubleValue());

        BigDecimal bd3 = new BigDecimal(totalPayment);
        bd3 = bd3.setScale(2, RoundingMode.HALF_EVEN);
        openedBillDetails.setPayment(bd3.doubleValue());

        BigDecimal bd4 = new BigDecimal(totalDiscount);
        bd4 = bd4.setScale(2, RoundingMode.HALF_EVEN);
        openedBillDetails.setTotalDiscount(bd4.doubleValue());

        openedBillDetails.setBillAmount(bd.doubleValue() + bd2.doubleValue() - bd3.doubleValue() - bd4.doubleValue());
        return openedBillDetails;
    }

    public SettlementDetails getSettlementDetails() {
        SettlementDetails settlementDetails = new SettlementDetails();
        /*
        List<PaymentType> paymentTypeList;
    List<HouseAccount> houseAccountList;
    List<ReservationRoomLoad> reservedRoomList;
    List<MAcCreditcard> mAcCreditcard;
         */
        Query hql3 = getPOSSession().createQuery("from PaymentType as pty where pty.paymentNo  <> '6' ");
        List<PaymentType> paymentTypeList = (List<PaymentType>) (hql3.list());
        Query hql4 = getResSession().createQuery("from HouseAccount ");
        List<HouseAccount> houseAccList = (List<HouseAccount>) (hql4.list());
        Query hql5 = getPOSSession().createQuery("from MAcCreditcard");
        List<MAcCreditcard> mAcCreditcard = (List<MAcCreditcard>) (hql5.list());

        settlementDetails.setPaymentTypeList(paymentTypeList);
        settlementDetails.setHouseAccountList(houseAccList);
        settlementDetails.setReservedRoomList(reservationDao.getReservationRooms());
        settlementDetails.setmAcCreditcard(mAcCreditcard);

        return settlementDetails;
    }
}
