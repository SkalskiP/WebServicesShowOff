import {INavigationBarButton} from "../interfaces/INavigationBarButton";
import {TabName} from "../utils/types/TabName";

const NavigationBarButtonsData:INavigationBarButton[] = [
    {
        displayName: "Dashboard",
        imageSource: "ico/1/dashboard.png",
        imageAlt: "dashboard",
        activeTabName: TabName.DASHBOARD,
        advancedAccess: false
    },
    {
        displayName: "Notifications",
        imageSource: "ico/1/notification.png",
        imageAlt: "notifications",
        activeTabName: TabName.NOTIFICATIONS,
        advancedAccess: false
    },
    {
        displayName: "History",
        imageSource: "ico/1/history.png",
        imageAlt: "history",
        activeTabName: TabName.HISTORY,
        advancedAccess: false
    },
    {
        displayName: "Menage users",
        imageSource: "ico/1/users.png",
        imageAlt: "menage users",
        activeTabName: TabName.MANAGE_USERS,
        advancedAccess: true
    },
    {
        displayName: "Settings",
        imageSource: "ico/1/settings.png",
        imageAlt: "settings",
        activeTabName: TabName.SETTINGS,
        advancedAccess: false
    }
];

export default NavigationBarButtonsData;