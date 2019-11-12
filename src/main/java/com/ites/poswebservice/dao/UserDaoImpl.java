package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontMealPeriod;
import com.ites.poswebservice.model.hotelpos.MRestaurant;
import com.ites.poswebservice.model.hotelpos.Userlogin;
import com.ites.poswebservice.model.random.POSUserLogin;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.ites.poswebservice.dao.hotelfinance.UserFDao;
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactoryHotelPos;

    public Session getPosSession() {
        return sessionFactoryHotelPos.openSession();
    }

//	@Autowired
//	private UserFDao userFdao;

    /*
	 * Query the hotelpos DB via entityManager bean to get the all available
	 * users.
	 * 
	 * @return List<User>
	 * 
	 * @exception @return null
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<POSUserLogin> getAllUsers() {
        String qry = "select new com.ites.poswebservice.model.random.POSUserLogin(us.userID,us.userName,us.pwd,us.userType,us.active,us.pWCord,us.isCustom) from Userlogin as us";
        try {
            Session session = getPosSession();
            List<POSUserLogin> allUsers = (List<POSUserLogin>) session.createQuery(qry).list();
            return allUsers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
	 * Query the hotelpos DB via entityManager bean to get the user related
	 * to the id.
	 * 
	 * @param int id
	 * 
	 * @return User
	 * 
	 * @exception @return null
     */
    @Override
    public Userlogin getUser(int id) {
        String qry = "from Userlogin where userID=" + id;
        try {
//			Session session = getSessionFactoryPos();
            Userlogin user = (Userlogin) getPosSession().createQuery(qry).uniqueResult();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean validateLoginUser(String username, String password) {
        boolean stat = false;
        String qry = "from Userlogin where userName = '" + username + "' and pWCord = '" + password + "' ";
        try {
            Userlogin user = (Userlogin) getPosSession().createQuery(qry).uniqueResult();
            if (user != null) {
                stat = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }

    @Override
    public List<MRestaurant> getRestuarantList() {
        List<MRestaurant> restuarantList = null;
        String qry2 = "from MRestaurant";
        try {
            restuarantList = (List<MRestaurant>) getPosSession().createQuery(qry2).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restuarantList;
    }

    @Override
    public List<FrontMealPeriod> getMealPreiodList() {
        List<FrontMealPeriod> frontMealPeriodList = null;
        String qry = "from FrontMealPeriod";
        try {
            frontMealPeriodList = (List<FrontMealPeriod>) getPosSession().createQuery(qry).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frontMealPeriodList;
    }

    public List<Object> getPosMachine() {
        List<Object> objList = new ArrayList<>();
        String qry = "select posIp from ConfigPosMachine";
        try {
            objList = (List<Object>) getPosSession().createQuery(qry).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objList;
    }

    public List<Userlogin> getUserLoginList() {
        List<Userlogin> objList = new ArrayList<>();
        String qry = "from Userlogin where userType ='2' and isShow ='1'";
        try {
            objList = (List<Userlogin>) getPosSession().createQuery(qry).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objList;
    }
}
