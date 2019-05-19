# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains enum that is holding names of errors that could happen turing soap connection
# ======================================================================================================================


from enum import Enum


class ErrorType(Enum):
    NO_ERROR = 1
    PARSING = 2
    WRONG_ID = 3
    NO_CONNECTION = 4