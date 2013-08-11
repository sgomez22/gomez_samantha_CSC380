package service;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 8/6/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(endpointInterface = "service.ZipCodeService", serviceName = "ZipCodeService")
public class ZipCodeServiceImpl implements ZipCodeService {

    private static final Map<Integer, State> STATES;
    static{
        STATES = new HashMap<Integer, State>();
        State initialState = new State();
        STATES.put(84111, new State("Utah", "UT"));
    }

    @Override
    public State getState(Integer zipCode) {
        return STATES.get(zipCode);
    }

    @Override
    public void addZipCode(State state, List<Integer> zipCodes) {
        for(Integer zipCode : zipCodes)
            if(!STATES.containsKey(zipCode))
                STATES.put(zipCode, state);
    }
}
