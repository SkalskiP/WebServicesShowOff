# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains function used to create app view visible at the very beginning of app.
# ======================================================================================================================


from ..utils.views_names import ViewsNames


def intro_view(router):
    with open("./src/data/intro.txt") as f:
        content = f.readlines()

    for index, line in enumerate(content):
        router.screen.addstr(index + 1, 4, line)

    router.screen.getch()
    router.current_view = ViewsNames.ACTIONS_MENU
