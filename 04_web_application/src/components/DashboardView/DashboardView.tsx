import React from "react";
import './DashboardView.scss';
import Settings from "../../settings/Settings";
import axios, {AxiosResponse} from "axios";
import {ResponseToObjectMapper} from "../../utils/ResponseToObjectMapper";
import {IParkingSpot} from "../../interfaces/IParkingSpot";
import TableBox from "../TableBox/TableBox";
import FilteringPanel from "../FilteringPanel/FilteringPanel";
import _ from 'lodash';
import PaginationPanel from "../PaginationPanel/PaginationPanel";

interface IState {
    tableData: IParkingSpot[];
    totalCount: number;
}

export default class DashboardView extends React.Component<{}, IState> {

    public state: IState = {
        tableData: [],
        totalCount: null,
    };

    protected headerLabels: string[] = ["Id", "Zone", "Street", "Number", "Status"];
    protected url: string = Settings.SERVER_NAME + "/" + Settings.DASHBOARD_REQUEST_PATH;
    protected batchSize: number = 20;
    protected pageIndex: number = 0;
    protected zoneName: string = "";
    protected streetName: string = "";

    public requestData = () => {
        axios.get(this.url, {params: {
                limit: this.batchSize,
                offset: this.pageIndex * this.batchSize,
                zone: this.zoneName.length > 2 ? this.zoneName.toLowerCase() : null,
                street: this.streetName.length > 2 ? this.streetName.toLowerCase() : null
            }})
            .then((response:AxiosResponse) => {
                const tableData:IParkingSpot[] = response.data.data.map(ResponseToObjectMapper.forDashboardRequest);
                this.setState({
                    tableData: tableData,
                    totalCount: response.data.totalCount
                });
            })
    };

    public debouncedRequestData =
        _.debounce(this.requestData, 500, {
            'leading': true,
            'trailing': true
        });

    public componentDidMount(): void {
        this.requestData();
    }

    protected onZoneNameChange = (value: string) => {
        const isDelete = value.length < this.zoneName.length;
        this.zoneName = value;
        if (this.zoneName.length > 2 || isDelete) {
            this.pageIndex = 0;
            this.debouncedRequestData();
        }
    };

    protected onStatusNameChange = (value: string) => {
        const isDelete = value.length < this.zoneName.length;
        this.streetName = value;
        if (this.streetName.length > 2 || isDelete) {
            this.pageIndex = 0;
            this.debouncedRequestData();
        }
    };

    protected onPageChange = (index:number) => {
        this.pageIndex = index - 1;
        this.debouncedRequestData();
    };

    protected renderHeader = (style: React.CSSProperties) => {
        return(
            <div className="TableHeader" style={style}>
                {this.headerLabels.map((label:string) => <div className="ColumnHeader" key={label}>
                    {label}
                </div>)}
            </div>
        )
    };

    protected renderFooter = (style: React.CSSProperties) => {
        return [<div className="FiltersWrapper">
            <FilteringPanel key={"Zone"} onTextChange={this.onZoneNameChange} label={"Zone"}/>
            <FilteringPanel key={"Street"} onTextChange={this.onStatusNameChange} label={"Street"}/>
        </div>,
            <PaginationPanel
                activePageIndex={this.pageIndex + 1}
                totalPagesCount={Math.floor(this.state.totalCount / this.batchSize) + 1}
                onActivePageChange={this.onPageChange}
            />]
    };

    protected renderContent = (style: React.CSSProperties) => {
        return(
            <div className="TableContent" style={style}>
                {this.state.tableData.map((data: IParkingSpot) => <div className="TableRow">
                    <div className="TableCell">{data.id}</div>
                    <div className="TableCell">{data.zone}</div>
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
                    tableWidth={1000}
                    renderHeader={this.renderHeader}
                    headerHeight={50}
                    renderContent={this.renderContent}
                    renderFooter={this.renderFooter}
                />
            </div>
        )
    }
}