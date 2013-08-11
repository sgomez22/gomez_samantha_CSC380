package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 8/11/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(name = "LunchService", targetNamespace = "http://localhost/LunchService")
public interface LunchService {

    @WebMethod
    public String getRestaurant(Restaurant rest);
}
