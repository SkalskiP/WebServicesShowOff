# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains enum that is holding names of all views used in project
# ======================================================================================================================


from enum import Enum


class ViewsNames(Enum):
    INTRO = 1
    ACTIONS_MENU = 2
    SELECT_SPOT_TO_OCCUPY = 3
    SELECT_SPOT_TO_RELEASE = 4
    SHOW_OCCUPY_SPOT_OUTCOME = 5
    SHOW_RELEASE_SPOT_OUTCOME = 6