package com.ites.poswebservice.services;

import com.ites.poswebservice.model.hotelpos.FrontMealPeriod;
import com.ites.poswebservice.model.hotelpos.MRestaurant;
import com.ites.poswebservice.model.hotelpos.Userlogin;
import com.ites.poswebservice.model.random.POSUserLogin;
import java.util.List;

//import com.ites.poswebservice.model.hotelFinance.UserF;
public interface UserService {
//	public List<UserF> getAllFinUsers();

    public Userlogin getUser(int id);

    public List<POSUserLogin> getAllUsers();

    public boolean validateLoginUser(String username, String password);

    public List<MRestaurant> getRestuarantList();

    public List<FrontMealPeriod> getMealPreiodList();

    public List<Object> getPosMachine();

    public List<Userlogin> getUserLoginList();
}
