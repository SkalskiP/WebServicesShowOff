package soap.parkingSpot;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ParkingSpotServiceImpl implements ParkingSpotService {

    @WebMethod
    public Boolean occupyParkingSpot(Integer spotId) {
        return true;
    }

    @WebMethod
    public Boolean releaseParkingSpot(Integer spotId) {
        return true;
    }
}
