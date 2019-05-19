# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains function used to create main app view.
# ======================================================================================================================


import curses
from ..utils.views_names import ViewsNames


def actions_menu_view(router):
    selection = -1
    option = 0

    while selection < 0:
        router.screen.clear()

        h = [0] * 3
        h[option] = curses.color_pair(1)

        router.screen.addstr(1, 4, "Please select an option...", curses.A_BOLD)
        router.screen.addstr(3, 4, "1 - Occupy parking space", h[0])
        router.screen.addstr(4, 4, "2 - Release parking space", h[1])
        router.screen.addstr(6, 4, "3 - Exit ('q')", h[2])

        q = router.screen.getch()

        if q == curses.KEY_UP:
            option = (option - 1) % len(h)
        elif q == curses.KEY_DOWN:
            option = (option + 1) % len(h)
        elif q == ord('\n'):
            selection = option

        if selection == 0:
            router.current_view = ViewsNames.SELECT_SPOT_TO_OCCUPY
        elif selection == 1:
            router.current_view = ViewsNames.SELECT_SPOT_TO_RELEASE
        elif q == ord('q') or selection == len(h) - 1:
            router.running = False