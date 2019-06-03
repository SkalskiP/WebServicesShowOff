import React from 'react';
import './HistoryView.scss';
import {HistoryTabName} from "../../utils/types/HistoryTabName";
import TableBox from "../TableBox/TableBox";
import {AppState} from "../../store";
import {connect} from "react-redux";
import {IParkingTicket} from "../../interfaces/IParkingTicket";
import axios, {AxiosResponse} from 'axios'
import Settings from "../../settings/Settings";
import {ResponseToObjectMapper} from "../../utils/ResponseToObjectMapper";

interface IProps {
    activeHistoryTabName: HistoryTabName;
}

interface IState {
    tableData: IParkingTicket[];
}

class HistoryViewComponent extends React.Component<IProps, IState> {

    public state: IState = {
        tableData: []
    };

    protected headerLabels: string[] = ["Id", "Street", "Number", "Ticket type", "Payment time", "Expiry time", "Departure time", "Status"];

    public Url:string = Settings.SERVER_NAME + "/" + Settings.HISTORY_REQUEST_PATH;

    public getQueryParams() {
        const startDate = new Date;
        const endDate = new Date;

        switch (this.props.activeHistoryTabName) {
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
            limit: 50,
            offset: 0,
            from: startYear + "-" + startMonth + "-" + startDay + " 00:00:00",
            to: endYear + "-" + endMonth + "-" + endDay + " 23:59:59"
        };
    }

    public requestData = () => {
        axios.get(this.Url, {params: this.getQueryParams()})
            .then((data:AxiosResponse) => {
                const tableData:IParkingTicket[] = data.data.map(ResponseToObjectMapper.fofHistoryRequest);
                this.setState({tableData: tableData});
            })
    };

    public componentDidMount(): void {
        this.requestData();
    }

    public componentDidUpdate(prevProps: Readonly<IProps>, prevState: Readonly<{}>, snapshot?: any): void {
        if (prevProps.activeHistoryTabName !== this.props.activeHistoryTabName) {
            this.requestData();
        }
    }

    protected renderHeader = (style: React.CSSProperties) => {
        return(
            <div className="TableHeader" style={style}>
                {this.headerLabels.map((label:string) => <div className="ColumnHeader">
                    {label}
                </div>)}
            </div>
        )
    };

    protected renderContent = (style: React.CSSProperties) => {
        return(
            <div className="TableContent" style={style}>
                {this.state.tableData.map((data: IParkingTicket) => <div className="TableRow">
                    <div className="TableCell">{data.id}</div>
                    <div className="TableCell">{data.street}</div>
                    <div className="TableCell">{data.number}</div>
                    <div className="TableCell">{data.ticketType}</div>
                    <div className="TableCell">{data.arrivalTime}</div>
                    <div className="TableCell">{data.expiryTime}</div>
                    <div className="TableCell">{data.departureTime}</div>
                    <div className="TableCell">{data.status}</div>
                </div>)}
            </div>
        )
    };

    public render() {
        return(
            <div className="HistoryView">
                <TableBox
                    tableWidth={1400}
                    renderHeader={this.renderHeader}
                    headerHeight={50}
                    renderContent={this.renderContent}
                />
            </div>
        )
    }
}

const mapStateToProps = (state: AppState) => ({
    activeHistoryTabName: state.general.activeHistoryTabName
});

export const HistoryView = connect(
    mapStateToProps,
)(HistoryViewComponent);