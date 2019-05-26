import {HistoryTabName} from "../utils/types/HistoryTabName";

export interface ISlimNavigationBarButton {
    displayName: string;
    imageSource: string;
    imageAlt: string;
    activeTabName: HistoryTabName;
}