# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains class responsible for soap comunication
# ======================================================================================================================

from zeep import Client
from ..config.config import Config


class SoapClient:

    @staticmethod
    def occupy_parking_spot(spot_id: int):
        client = Client(Config.WSDL_URL)
        response = client.service.occupyParkingSpot(arg0=spot_id)
        return response