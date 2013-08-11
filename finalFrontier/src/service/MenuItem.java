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

public class MenuItem {

    private String foodName;
    private String price;

    public MenuItem(){}

    public MenuItem(String foodName, String price){
        this.foodName = foodName;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
