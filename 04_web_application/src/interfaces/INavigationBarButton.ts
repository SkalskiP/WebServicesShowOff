import {TabName} from "../utils/types/TabName";

export interface INavigationBarButton {
    displayName: string;
    imageSource: string;
    imageAlt: string;
    activeTabName: TabName;
    activeTabSubtitle: string;
    advancedAccess: boolean;
}