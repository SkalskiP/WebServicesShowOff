package rest.parking_spot;

import dto.ParkingSpotDTO;

import java.io.Serializable;
import java.util.List;

public class ParkingSpotRaportData implements Serializable {
    private List<ParkingSpotDTO> data;
    private Long totalCount;

    public List<ParkingSpotDTO> getData() {
        return data;
    }

    public void setData(List<ParkingSpotDTO> data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
