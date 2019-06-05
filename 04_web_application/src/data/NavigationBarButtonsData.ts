import { INavigationBarButton } from "../interfaces/INavigationBarButton";
import { TabName } from "../utils/types/TabName";

const NavigationBarButtonsData: INavigationBarButton[] = [
  {
    displayName: "Dashboard",
    imageSource: "ico/dashboard.png",
    imageAlt: "dashboard",
    activeTabName: TabName.DASHBOARD,
    activeTabSubtitle: "Parking space",
    advancedAccess: false
  },
  {
    displayName: "Notifications",
    imageSource: "ico/notification.png",
    imageAlt: "notifications",
    activeTabName: TabName.NOTIFICATIONS,
    activeTabSubtitle: "Most recent",
    advancedAccess: false
  },
  {
    displayName: "History",
    imageSource: "ico/history.png",
    imageAlt: "history",
    activeTabName: TabName.HISTORY,
    activeTabSubtitle: "Last weeks",
    advancedAccess: false
  },
  {
    displayName: "Menage users",
    imageSource: "ico/users.png",
    imageAlt: "menage users",
    activeTabName: TabName.MANAGE_USERS,
    activeTabSubtitle: "Change other users' settings",
    advancedAccess: true
  },
  {
    displayName: "Account settings",
    imageSource: "ico/settings.png",
    imageAlt: "settings",
    activeTabName: TabName.SETTINGS,
    activeTabSubtitle: "Change your",
    advancedAccess: false
  }
];

export default NavigationBarButtonsData;
