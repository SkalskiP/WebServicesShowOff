import React from "react";
import './DashboardView.scss';
import Settings from "../../settings/Settings";
import axios, {AxiosResponse} from "axios";
import {ResponseToObjectMapper} from "../../utils/ResponseToObjectMapper";
import {IParkingSpot} from "../../interfaces/IParkingSpot";
import TableBox from "../TableBox/TableBox";

interface IState {
    tableData: IParkingSpot[];
}

export default class DashboardView extends React.Component<{}, IState> {

    public state: IState = {
        tableData: []
    };

    protected headerLabels: string[] = ["Id", "Street", "Number", "Status"];

    public Url:string = Settings.SERVER_NAME + "/" + Settings.DASHBOARD_REQUEST_PATH;

    public requestData = () => {
        axios.get(this.Url)
            .then((data:AxiosResponse) => {
                const tableData:IParkingSpot[] = data.data.map(ResponseToObjectMapper.forDashboardRequest);
                this.setState({tableData: tableData});
            })
    };

    public componentDidMount(): void {
        this.requestData();
    }

    protected renderHeader = (style: React.CSSProperties) => {
        return(
            <div className="TableHeader" style={style}>
                {this.headerLabels.map((label:string) => <div className="ColumnHeader" key={label}>
                    {label}
                </div>)}
            </div>
        )
    };

    protected renderContent = (style: React.CSSProperties) => {
        return(
            <div className="TableContent" style={style}>
                {this.state.tableData.map((data: IParkingSpot) => <div className="TableRow">
                    <div className="TableCell">{data.id}</div>
                    <div className="TableCell">{data.street}</div>
                    <div className="TableCell">{data.number}</div>
                    <div className="TableCell">{data.status}</div>
                </div>)}
            </div>
        )
    };

    public render() {
        return(
            <div className="DashboardView">
                <TableBox
                    tableWidth={800}
                    renderHeader={this.renderHeader}
                    headerHeight={50}
                    renderContent={this.renderContent}
                    renderFooter={null}
                />
            </div>
        )
    }
}