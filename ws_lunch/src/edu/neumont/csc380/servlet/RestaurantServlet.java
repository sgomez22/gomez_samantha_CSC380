package edu.neumont.csc380.servlet;

import edu.neumont.csc380.soapRequest.Envelope;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            JAXBContext soapRequestContext = JAXBContext.newInstance("edu.neumont.csc380.soapRequest");
            Unmarshaller soapRequestUnMarshaller = soapRequestContext.createUnmarshaller();
            InputStream inputStream = req.getInputStream();
            Envelope soapRequestEnvelope = (Envelope)soapRequestUnMarshaller.unmarshal(inputStream);
        }catch(JAXBException ex){

        }
    }
}
