package service;

import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 8/11/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(endpointInterface = "service.LunchService", serviceName ="LunchService" )
public class LunchServiceImpl implements LunchService {

    @Override
    public String getRestaurant(Restaurant rest){
       return rest.getRestaurantName();
    }
}
