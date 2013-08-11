package edu.neumont.csc380.servlet;

import edu.neumont.csc380.soapRequest.Envelope;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 7/30/13
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "RestaurantServlet", urlPatterns = "/restaurant")
public class RestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
             JAXBContext jaxb = JAXBContext.newInstance("edu.neumont.csc380.soapRequest");
             Unmarshaller reqUM = jaxb.createUnmarshaller();
             InputStream inputStream = request.getInputStream();
             Envelope reqEnvelope = (Envelope)reqUM.unmarshal(inputStream);

             JAXBContext jaxbResp = JAXBContext.newInstance("edu.neumont.csc380.soapResponse");
             Marshaller marsh = jaxbResp.createMarshaller();

             edu.neumont.csc380.soapResponse.ObjectFactory objf = new edu.neumont.csc380.soapResponse.ObjectFactory();
             edu.neumont.csc380.soapResponse.Envelope resEnvelope = objf.createEnvelope();
             edu.neumont.csc380.soapResponse.Restaurant restaurant = objf.createRestaurant();
             restaurant.setName("Lamb's Grill");

             edu.neumont.csc380.soapResponse.Body body = objf.createBody();
             edu.neumont.csc380.soapResponse.GetRestaurantsResponse restResp = objf.createGetRestaurantsResponse();
             restResp.setRestaurant(restaurant);
             resEnvelope.setBody(body);

             OutputStream stream = response.getOutputStream();
             marsh.marshal(resEnvelope, stream);

             return;
         } catch(Exception e){

         }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Completed order");
    }
}
