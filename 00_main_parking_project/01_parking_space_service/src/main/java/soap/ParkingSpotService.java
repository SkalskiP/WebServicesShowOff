package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ParkingSpotService {

    @WebMethod
    Boolean occupyParkingSpot(Integer spotId);

    @WebMethod
    Boolean releaseParkingSpot(Integer spotId);
}