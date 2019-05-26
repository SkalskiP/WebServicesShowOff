import {ISlimNavigationBarButton} from "../interfaces/ISlimNavigationBarButton";
import {HistoryTabName} from "../utils/types/HistoryTabName";

const HistoryButtonsData: ISlimNavigationBarButton[] = [
    {
        displayName: "Today",
        imageSource: "ico/today.png",
        imageAlt: "today",
        activeTabName: HistoryTabName.TODAY
    },
    {
        displayName: "Yesterday",
        imageSource: "ico/yesterday.png",
        imageAlt: "yesterday",
        activeTabName: HistoryTabName.YESTERDAY
    },
    {
        displayName: "Last week",
        imageSource: "ico/last_week.png",
        imageAlt: "last week",
        activeTabName: HistoryTabName.LAST_WEEK
    },
    {
        displayName: "Last month",
        imageSource: "ico/last_month.png",
        imageAlt: "last month",
        activeTabName: HistoryTabName.LAST_MONTH
    },
    {
        displayName: "Last year",
        imageSource: "ico/last_year.png",
        imageAlt: "lat year",
        activeTabName: HistoryTabName.LAST_YEAR
    }
];

export default HistoryButtonsData;