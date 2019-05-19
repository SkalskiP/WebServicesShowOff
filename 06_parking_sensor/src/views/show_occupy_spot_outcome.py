# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains function used to display outcome of SOAP request
# ======================================================================================================================

import curses
from ..utils.views_names import ViewsNames
from ..utils.error_type import ErrorType


def show_occupy_spot_outcome(router):
    router.screen.clear()

    if router.soap_response and router.error_type == ErrorType.NO_ERROR:
        router.screen.addstr(1, 4, "Parking spot with id: {} is now occupied.".format(router.spot_id), curses.A_BOLD)
    elif router.error_type == ErrorType.PARSING:
        router.screen.addstr(1, 4, "Id that you provided is not a number.", curses.A_BOLD)
    elif router.error_type == ErrorType.WRONG_ID:
        router.screen.addstr(1, 4, "Id that you provided is not valid. It seems that there is no spot with that id.",
                             curses.A_BOLD)
    elif router.error_type == ErrorType.NO_CONNECTION:
        router.screen.addstr(1, 4, "Connection failed.",
                             curses.A_BOLD)
    elif not router.soap_response:
        router.screen.addstr(1, 4, "Parking spot with id: {} is already occupied.".format(router.spot_id), curses.A_BOLD)

    q = router.screen.getch()

    router.soap_response = None
    router.error_type = None
    router.spot_id = None

    router.current_view = ViewsNames.ACTIONS_MENU