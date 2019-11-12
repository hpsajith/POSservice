package com.ites.poswebservice.model.random;

import java.util.List;

import com.ites.poswebservice.model.hotelpos.FrontMealPeriod;
import com.ites.poswebservice.model.hotelpos.MRestaurant;

public class Random {

	List<MRestaurant> restuarantList;
	List<FrontMealPeriod> mealPeriodList;
	
	public Random(){
		
	}
	
	public Random(List<MRestaurant> restuarantList,List<FrontMealPeriod> mealPeriodList){
		this.restuarantList =restuarantList;
		this.mealPeriodList =mealPeriodList;
	}
//	public Random(List<MRestaurant> restuarantList){
//		this.restuarantList =restuarantList;
//	}
	
	public List<MRestaurant> getRestuarantList() {
		return restuarantList;
	}
	public void setRestuarantList(List<MRestaurant> restuarantList) {
		this.restuarantList = restuarantList;
	}
	public List<FrontMealPeriod> getMealPeriodList() {
		return mealPeriodList;
	}
	public void setMealPeriodList(List<FrontMealPeriod> mealPeriodList) {
		this.mealPeriodList = mealPeriodList;
	}	
}