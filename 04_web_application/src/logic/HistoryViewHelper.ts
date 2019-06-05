import {HistoryTabName} from "../utils/types/HistoryTabName";

export class HistoryViewHelper {
    public static getQueryParams(activeHistoryTabName:HistoryTabName, activePageIndex: number, batchSize: number) {

        console.log("activePageIndex", activePageIndex);

        const startDate = new Date();
        const endDate = new Date();

        switch (activeHistoryTabName) {
            case HistoryTabName.TODAY:
                startDate.setTime(startDate.getTime() - 24 * 3600000);
                break;
            case HistoryTabName.YESTERDAY:
                startDate.setTime(startDate.getTime() - 2 * 24 * 3600000);
                endDate.setTime(endDate.getTime() - 24 * 3600000);
                break;
            case HistoryTabName.LAST_WEEK:
                startDate.setTime(startDate.getTime() - 7 * 24 * 3600000);
                break;
            case HistoryTabName.LAST_MONTH:
                startDate.setTime(startDate.getTime() - 30 * 24 * 3600000);
                break;
            case HistoryTabName.LAST_YEAR:
                startDate.setTime(startDate.getTime() - 365 * 24 * 3600000);
                break;
        }

        const startYear = startDate.getFullYear();
        const startDay = startDate.getDate() > 9 ? "" + startDate.getDate() : "0" + startDate.getDate();
        const startMonth = (startDate.getMonth() + 1) > 9 ? "" + (startDate.getMonth() + 1) : "0" + (startDate.getMonth() + 1);

        const endYear = endDate.getFullYear();
        const endDay = endDate.getDate() > 9 ? "" + endDate.getDate() : "0" + endDate.getDate();
        const endMonth = (endDate.getMonth() + 1) > 9 ? "" + (endDate.getMonth() + 1) : "0" + (endDate.getMonth() + 1);

        return {
            limit: batchSize,
            offset: (activePageIndex - 1) * batchSize,
            from: startYear + "-" + startMonth + "-" + startDay + " 00:00:00",
            to: endYear + "-" + endMonth + "-" + endDay + " 23:59:59"
        };
    }
}