# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains function used to define id of parking spot to be occupied
# ======================================================================================================================


import curses
from ..utils.views_names import ViewsNames


def select_spot_to_occupy_view(router):
    router.screen.clear()

    router.screen.addstr(1, 4, "Insert id of parking spot you want to mark as occupied...", curses.A_BOLD)

    router.screen.addstr(2, 4, "Type in id or insert q to aboard:")

    s = router.read_text_from_user(4, 4)

    if s is not "q":
        router.selected_spot = int(s)
        router.current_view = ViewsNames.SHOW_OCCUPY_SPOT_OUTCOME
    else:
        router.current_view = ViewsNames.ACTIONS_MENU