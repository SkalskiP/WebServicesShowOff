# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# Main file used to run Parking Sensor Mock in terminal
# ======================================================================================================================

from src.view_routing import ViewRutting


if __name__ == '__main__':
    view_routing = ViewRutting()
    view_routing.run_app()
