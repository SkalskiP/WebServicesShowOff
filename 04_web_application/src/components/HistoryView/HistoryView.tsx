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
import {HistoryViewHelper} from "../../logic/HistoryViewHelper";
import PaginationPanel from "../PaginationPanel/PaginationPanel";

interface IProps {
    activeHistoryTabName: HistoryTabName;
}

interface IState {
    tableData: IParkingTicket[];
    totalCount: number;
    activePageIndex: number;
}

class HistoryViewComponent extends React.Component<IProps, IState> {

    public state: IState = {
        tableData: [],
        totalCount: null,
        activePageIndex: 1
    };

    protected headerLabels: string[] = ["Id", "Street", "Number", "Ticket type", "Payment time", "Expiry time", "Departure time", "Status"];
    protected url:string = Settings.SERVER_NAME + "/" + Settings.HISTORY_REQUEST_PATH;
    protected batchSize:number = 20;

    public componentDidMount(): void {
        this.requestData(1);
    }

    public componentDidUpdate(prevProps: Readonly<IProps>, prevState: Readonly<{}>, snapshot?: any): void {
        if (prevProps.activeHistoryTabName !== this.props.activeHistoryTabName) {
            this.requestData(1);
        }
    }

    public requestData = (pageIndex: number) => {
        axios.get(this.url, {params: HistoryViewHelper.getQueryParams(this.props.activeHistoryTabName, pageIndex, this.batchSize)})
            .then((response:AxiosResponse) => {
                const tableData:IParkingTicket[] = response.data.data.map(ResponseToObjectMapper.forHistoryRequest);
                const totalCount:number = response.data.totalCount;

                this.setState({
                    tableData: tableData,
                    totalCount: totalCount,
                    activePageIndex: pageIndex
                });
            })
    };

    protected changePageHandler = (index:number) => {
        this.requestData(index);
    };

    protected renderTableHeader = (style: React.CSSProperties) => {
        return(
            <div className="TableHeader" style={style}>
                {this.headerLabels.map((label:string) => <div className="ColumnHeader">
                    {label}
                </div>)}
            </div>
        )
    };

    protected renderTableContent = (style: React.CSSProperties) => {
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

    protected renderTableFooter = (style: React.CSSProperties) => {
        return(
            [<div/>,
            <PaginationPanel
                activePageIndex={this.state.activePageIndex}
                totalPagesCount={Math.floor(this.state.totalCount / this.batchSize) + 1}
                onActivePageChange={this.changePageHandler}
            />]
        )
    };

    public render() {
        return(
            <div className="HistoryView">
                <TableBox
                    totalTableContentWidth={1400}
                    headerHeight={50}
                    renderHeader={this.renderTableHeader}
                    renderContent={this.state.tableData.length !== 0 ? this.renderTableContent : null}
                    renderFooter={this.renderTableFooter}
                    noDataMessage={"I don't have any \n Parking Tickets data to show"}
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