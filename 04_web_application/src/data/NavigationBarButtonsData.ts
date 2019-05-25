import {INavigationBarButton} from "../interfaces/INavigationBarButton";
import {TabName} from "../utils/types/TabName";

const NavigationBarButtonsData:INavigationBarButton[] = [
    {
        displayName: "Dashboard",
        imageSource: "ico/1/dashboard.png",
        imageAlt: "dashboard",
        activeTabName: TabName.DASHBOARD,
        activeTabSubtitle: "Parking space",
        advancedAccess: false
    },
    {
        displayName: "Notifications",
        imageSource: "ico/1/notification.png",
        imageAlt: "notifications",
        activeTabName: TabName.NOTIFICATIONS,
        activeTabSubtitle: "Most recent",
        advancedAccess: false
    },
    {
        displayName: "History",
        imageSource: "ico/1/history.png",
        imageAlt: "history",
        activeTabName: TabName.HISTORY,
        activeTabSubtitle: "Last weeks",
        advancedAccess: false
    },
    {
        displayName: "Menage users",
        imageSource: "ico/1/users.png",
        imageAlt: "menage users",
        activeTabName: TabName.MANAGE_USERS,
        activeTabSubtitle: "Change other users' settings",
        advancedAccess: true
    },
    {
        displayName: "Account settings",
        imageSource: "ico/1/settings.png",
        imageAlt: "settings",
        activeTabName: TabName.SETTINGS,
        activeTabSubtitle: "Change your account settings",
        advancedAccess: false
    }
];

export default NavigationBarButtonsData;