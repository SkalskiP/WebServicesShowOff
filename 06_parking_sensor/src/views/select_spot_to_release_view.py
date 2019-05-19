# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains function used to define id of parking spot to be released
# ======================================================================================================================


import curses
import zeep
import requests
from ..utils.views_names import ViewsNames
from ..utils.soap_client import SoapClient
from ..utils.error_type import ErrorType


def select_spot_to_release_view(router):
    router.screen.clear()

    router.screen.addstr(1, 4, "Insert id of parking spot you want to mark as released...", curses.A_BOLD)

    router.screen.addstr(2, 4, "Type in id or insert q to aboard:")

    s = router.read_text_from_user(4, 4)

    if s is not "q":
        try:
            spot_id = int(s)
            router.spot_id = spot_id
            router.soap_response = SoapClient.release_parking_spot(spot_id)
            router.error_type = ErrorType.NO_ERROR
        except ValueError:
            router.error_type = ErrorType.PARSING
        except zeep.exceptions.Fault:
            router.error_type = ErrorType.WRONG_ID
        except requests.exceptions.ConnectionError:
            router.error_type = ErrorType.NO_CONNECTION
        finally:
            router.current_view = ViewsNames.SHOW_RELEASE_SPOT_OUTCOME
    else:
        router.current_view = ViewsNames.ACTIONS_MENU
