import React from 'react';
import './HistoryView.scss';
import {HistoryTabName} from "../../utils/types/HistoryTabName";
import TableBox from "../TableBox/TableBox";
import {AppState} from "../../store";
import {connect} from "react-redux";
import {IParkingTicket} from "../../interfaces/IParkingTicket";

interface IProps {
    activeHistoryTabName: HistoryTabName;
}

class HistoryViewComponent extends React.Component<IProps, {}> {

    protected headerLabels: string[] = ["Id", "Street", "Number", "Ticket type", "Start date", "End date", "Status"];

    protected tableData: IParkingTicket[] = [
        {
            id: 1,
            street: "Street 1",
            number: 1,
            ticketType: "Type 1",
            startTime: "xxxx",
            endTime: "yyyy",
            status: "CANCELED"
        },
        {
            id: 1,
            street: "Street 1",
            number: 1,
            ticketType: "Type 1",
            startTime: "xxxx",
            endTime: "yyyy",
            status: "CANCELED"
        },
        {
            id: 1,
            street: "Street 1",
            number: 1,
            ticketType: "Type 1",
            startTime: "xxxx",
            endTime: "yyyy",
            status: "CANCELED"
        },
        {
            id: 1,
            street: "Street 1",
            number: 1,
            ticketType: "Type 1",
            startTime: "xxxx",
            endTime: "yyyy",
            status: "CANCELED"
        },
        {
            id: 1,
            street: "Street 1",
            number: 1,
            ticketType: "Type 1",
            startTime: "xxxx",
            endTime: "yyyy",
            status: "CANCELED"
        },
    ];

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
                {this.tableData.map((data: IParkingTicket) => <div className="TableRow">
                    <div className="TableCell">{data.id}</div>
                    <div className="TableCell">{data.street}</div>
                    <div className="TableCell">{data.number}</div>
                    <div className="TableCell">{data.ticketType}</div>
                    <div className="TableCell">{data.startTime}</div>
                    <div className="TableCell">{data.endTime}</div>
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