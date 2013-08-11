package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 8/11/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */

public class Restaurant {

    private String restaurantName;

    public  Restaurant(){}

    public Restaurant(String restaurantName){
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
