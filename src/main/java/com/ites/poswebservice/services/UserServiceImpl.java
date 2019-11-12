package com.ites.poswebservice.services;

import com.ites.poswebservice.dao.UserDao;
import com.ites.poswebservice.model.hotelpos.FrontMealPeriod;
import com.ites.poswebservice.model.hotelpos.MRestaurant;
import com.ites.poswebservice.model.hotelpos.Userlogin;
import com.ites.poswebservice.model.random.POSUserLogin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

//	@Autowired
//	UserFDao userFDao;

	@Autowired
	UserDao userDao;
	
	/* 
	 * Get all the available users from DAO
	 * 
	 * @return List<User>
	 */
//	@Override
//	public List<UserF> getAllFinUsers() {
//		userFDao.getAllFinUsers();
//		return null;
//	}

	/* 
	 * Get a particular user from DAO.
	 * 
	 * @param int id
	 * 
	 * @return User
	 */
	@Override
	public List<POSUserLogin> getAllUsers(){
		List<POSUserLogin> userlist = userDao.getAllUsers();
		return userlist;
	}
	
	@Override
	public Userlogin getUser(int id) {
		Userlogin user = userDao.getUser(id);
		return user;
	}

	@Override
	public boolean validateLoginUser(String username, String password){
		boolean restuarantList = userDao.validateLoginUser(username,password);
		return restuarantList;		
	}
	
	@Override
	public List<MRestaurant> getRestuarantList(){
		List<MRestaurant> restuarantList = userDao.getRestuarantList();
		return restuarantList;	
	}
	
	@Override
	public List<FrontMealPeriod> getMealPreiodList(){
		List<FrontMealPeriod> mealPeriodList = userDao.getMealPreiodList();
		return mealPeriodList;	
	}
        
        @Override
        public List<Object> getPosMachine(){
        List<Object> machnelist = userDao.getPosMachine();
		return machnelist;	
        }
        
        @Override
        public List<Userlogin> getUserLoginList(){
        List<Userlogin> userlist = userDao.getUserLoginList();
		return userlist;	
        }
}