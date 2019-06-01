package jms;

import java.io.Serializable;

public class NewUnpaidParkingSpotMessage implements Serializable {
    private Integer spotId;

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }
}