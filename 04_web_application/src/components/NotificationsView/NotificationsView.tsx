import React from "react";
import './NotificationsView.scss';
import Settings from "../../settings/Settings";
import axios, {AxiosResponse} from "axios";
import {ResponseToObjectMapper} from "../../utils/ResponseToObjectMapper";
import TableBox from "../TableBox/TableBox";
import {IParkingSystemNotification} from "../../interfaces/IParkingSystemNotification";

interface IState {
    tableData: IParkingSystemNotification[];
}

export default class NotificationsView extends React.Component<{}, IState> {

    public state: IState = {
        tableData: []
    };

    protected headerLabels: string[] = ["Employee Id", "Spot Id", "Ticket Id", "Status"];

    public Url:string = Settings.SERVER_NAME + "/" + Settings.NOTIFICATIONS_REQUEST_PATH;

    public requestData = () => {
        axios.get(this.Url)
            .then((data:AxiosResponse) => {
                const tableData:IParkingSystemNotification[] = data.data.map(ResponseToObjectMapper.forNotificationsRequest);
                this.setState({tableData: tableData});
            })
    };

    public componentDidMount(): void {
        this.requestData();
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
                {this.state.tableData.map((data: IParkingSystemNotification) => <div className="TableRow">
                    <div className="TableCell">{data.employeeId}</div>
                    <div className="TableCell">{data.spotId}</div>
                    <div className="TableCell">{data.ticketId}</div>
                    <div className="TableCell">{data.status}</div>
                </div>)}
            </div>
        )
    };

    public render() {
        return(
            <div className="DashboardView">
                <TableBox
                    totalTableContentWidth={800}
                    renderHeader={this.renderHeader}
                    headerHeight={50}
                    renderContent={this.state.tableData.length !== 0 ? this.renderContent : null}
                    renderFooter={null}
                    noDataMessage={"I don't have any \n Notifications to show"}
                />
            </div>
        )
    }
}