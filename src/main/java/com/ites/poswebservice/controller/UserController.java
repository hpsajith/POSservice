package com.ites.poswebservice.controller;

import com.ites.poswebservice.model.hotelpos.FrontMealPeriod;
import com.ites.poswebservice.model.hotelpos.MRestaurant;
import com.ites.poswebservice.model.hotelpos.Userlogin;
import com.ites.poswebservice.model.random.OrderedBillLs;
import com.ites.poswebservice.model.random.POSUserLogin;
import com.ites.poswebservice.model.random.Random;
import com.ites.poswebservice.services.OrderService;
import com.ites.poswebservice.services.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/UserController"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    /**
     * HTTP endpoint to get all the users available in the system.
     *
     * {@link} GET [Host]:[Port]/UserController/getAllUsers
     *
     * @return List<User>
     */
    @RequestMapping(value = {"getAllUsers"}, method = RequestMethod.GET)
    public @ResponseBody
    List<POSUserLogin> getAllUsers() {
        System.out.println("****Begin*****");
        List<Object> posMachineList = userService.getPosMachine();
        List<POSUserLogin> users = userService.getAllUsers();
        POSUserLogin obj = new POSUserLogin();
        obj = users.get(0);
        obj.setPosMachine(posMachineList);
        return users;
    }

    /**
     * HTTP endpoint to get a particular user available in the system.
     *
     * {@link} GET [Host]:[Port]/UserController/getUser
     *
     * @param int id
     *
     * @return List<User>
     */
    @RequestMapping(value = {"/getUser"}, method = RequestMethod.GET)
    public @ResponseBody
    Userlogin getUser(@RequestParam(value = "id", defaultValue = "0") int id) {
        Userlogin user = userService.getUser(id);
        return user;
    }

    @RequestMapping(value = {"/validateLoginUser"}, method = RequestMethod.GET)
    public @ResponseBody
    List<Random> validateLoginUser(@RequestParam(value = "username", defaultValue = "0") String username,
            @RequestParam(value = "password", defaultValue = "0") String password) {
        List<MRestaurant> restuarantList = new ArrayList<>();
        List<FrontMealPeriod> mealPeriodList = new ArrayList<>();
        List<Random> randomList = new ArrayList<>();

        boolean userExist = userService.validateLoginUser(username, password);
        if (userExist) {
            restuarantList = getRestuarantList();
            mealPeriodList = getMealPreiodList();
            Random random2 = new Random(restuarantList, mealPeriodList);
            randomList.add(random2);
            return randomList;
        } else {
            Random random = null;
            randomList.add(random);
            return randomList;
        }
    }

    @RequestMapping(value = {"/casvalidateLoginUser"}, method = RequestMethod.GET)
    public @ResponseBody
    List<OrderedBillLs> casvalidateLoginUser(@RequestParam(value = "username", defaultValue = "0") String username,
            @RequestParam(value = "password", defaultValue = "0") String password
    ) {
        List<OrderedBillLs> oderedBillList = new ArrayList<>();
        List<MRestaurant> restuarantList = new ArrayList<>();
        List<FrontMealPeriod> mealPeriodList = new ArrayList<>();
        List<Userlogin> userLoginList = new ArrayList<>();
        boolean userExist = userService.validateLoginUser(username, password);
        if (userExist) {
            Date date = new Date();
            restuarantList = getRestuarantList();
            mealPeriodList = getMealPreiodList();
            userLoginList = getUserLogin();
            oderedBillList = orderService.getOrderedBillList(date);
            oderedBillList.get(0).setRestuarantList(restuarantList);
            oderedBillList.get(0).setMealPeriodList(mealPeriodList);
            oderedBillList.get(0).setUserLogin(userLoginList);
            return oderedBillList;
        } else {
            return oderedBillList;
        }
    }
    public @ResponseBody
    List<MRestaurant> getRestuarantList() {
        List<MRestaurant> restuarantList = userService.getRestuarantList();
        return restuarantList;
    }

    public @ResponseBody
    List<FrontMealPeriod> getMealPreiodList() {
        List<FrontMealPeriod> mealPeriodList = userService.getMealPreiodList();
        return mealPeriodList;
    }
    
    public @ResponseBody
    List<Userlogin> getUserLogin() {
        List<Userlogin> userLoginList = userService.getUserLoginList();
        return userLoginList;
    }
}
