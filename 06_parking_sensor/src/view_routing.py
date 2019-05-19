# ======================================================================================================================
# PROJECT NAME:             Parking Sensor Mock
# FILE NAME:                Main
# FILE VERSION:             1.0
# DATE:                     19.05.2019
# AUTHOR:                   Piotr Skalski [github.com/SkalskiP]
# ======================================================================================================================
# File contains class responsible for rutting views of terminal application.
# ======================================================================================================================

import curses
from .views.intro_view import intro_view
from .views.select_spot_to_occupy_view import select_spot_to_occupy_view
from .views.select_spot_to_release_view import select_spot_to_release_view
from .views.actions_menu_view import actions_menu_view
from .views.show_occupy_spot_outcome import show_occupy_spot_outcome
from .views.show_release_spot_outcome import show_release_spot_outcome
from .utils.views_names import ViewsNames


class ViewRutting:
    def __init__(self):
        self.spot_id = None
        self.soap_response = None
        self.error_type = None
        self.screen = self.init_screen()
        self.running = True
        self.current_view = ViewsNames.INTRO
        self.views = {
            ViewsNames.INTRO: intro_view,
            ViewsNames.ACTIONS_MENU: actions_menu_view,
            ViewsNames.SELECT_SPOT_TO_OCCUPY: select_spot_to_occupy_view,
            ViewsNames.SELECT_SPOT_TO_RELEASE: select_spot_to_release_view,
            ViewsNames.SHOW_OCCUPY_SPOT_OUTCOME: show_occupy_spot_outcome,
            ViewsNames.SHOW_RELEASE_SPOT_OUTCOME: show_release_spot_outcome,
        }

    def run_app(self):
        while self.running:
            self.views[self.current_view](self)
        self.close_screen()

    @staticmethod
    def init_screen():
        screen = curses.initscr()
        curses.noecho()
        curses.curs_set(0)
        curses.start_color()
        curses.init_pair(1, curses.COLOR_CYAN, curses.COLOR_BLACK)
        screen.keypad(1)

        return screen

    def close_screen(self):
        self.screen.clear()
        curses.endwin()
        exit()

    def read_text_from_user(self, row, column):
        self.screen.addstr(row, column, " >> ")

        curses.echo()
        curses.curs_set(1)

        input_text = self.screen.getstr(row, column + 4, 100).decode(encoding="utf-8")

        curses.noecho()
        curses.curs_set(0)

        return input_text
