package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontMealPeriod;
import com.ites.poswebservice.model.hotelpos.MRestaurant;
import com.ites.poswebservice.model.hotelpos.Userlogin;
import com.ites.poswebservice.model.random.POSUserLogin;
import java.util.List;

public interface UserDao {
	List<POSUserLogin> getAllUsers();
	Userlogin getUser(int id);
	boolean validateLoginUser(String username, String password);
	List<MRestaurant> getRestuarantList();
	List<FrontMealPeriod> getMealPreiodList();

    public List<Object> getPosMachine();

    public List<Userlogin> getUserLoginList();
}