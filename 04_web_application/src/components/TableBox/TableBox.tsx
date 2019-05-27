import React from 'react';
import './TableBox.scss';
import  Scrollbars  from 'react-custom-scrollbars';

interface IProps {
    columnWidth: number;
    headerLabels: string[];
}

interface IState {
    tableWidth: number;
    tableHeight: number;
    tableLeftOffset: number;
}

class TableBox extends React.Component<IProps, IState> {

    public state: IState = {
        tableWidth: null,
        tableHeight: null,
        tableLeftOffset: 0,
    };

    protected tableWrapper: HTMLDivElement;
    protected tableWidth: number;

    constructor(props) {
        super(props);
        this.tableWidth = this.props.columnWidth * this.props.headerLabels.length;
    }

    protected resizeTable = ():void => {
        const tableWrapperSize = this.tableWrapper.getBoundingClientRect();

        this.setState({
            tableWidth: Math.min(this.tableWidth, tableWrapperSize.width),
            tableHeight: tableWrapperSize.height
        });
    };

    protected getHeaderContent = () => {
        return this.props.headerLabels.map(
            (value: string) => <div className="ColumnHeader">
                {value}
            </div>
        )
    };

    public componentDidMount(): void {
        this.resizeTable();
        window.addEventListener("resize", this.resizeTable);

    }

    public componentWillUnmount(): void {
        window.removeEventListener("resize", this.resizeTable);
    }

    public handleScrollFrame = (value) => {
        this.setState({tableLeftOffset: - value.scrollLeft})
    };

    public render() {
        const {tableWidth, tableHeight, tableLeftOffset} = this.state;

        return(
            <div className="TableBoxWrapper" ref={ref => this.tableWrapper = ref}>
                <div className="TableBox" style={{width: tableWidth, height: tableHeight}}>
                    <div className="HeaderWrapper">
                        <div className="TableHeader" style={{width: this.tableWidth, left: tableLeftOffset}}>
                            {this.getHeaderContent()}
                        </div>
                    </div>
                    <div className="TableWrapper">
                        <Scrollbars
                            onScrollFrame={this.handleScrollFrame}
                            autoHide={true}
                        >
                            <div className="TableContent">
                                <div className="TableColumn" style={{height: 2000}}/>
                                <div className="TableColumn" style={{height: 2000}}/>
                                <div className="TableColumn" style={{height: 2000}}/>
                                <div className="TableColumn" style={{height: 2000}}/>
                                <div className="TableColumn" style={{height: 2000}}/>
                                <div className="TableColumn" style={{height: 2000}}/>
                                <div className="TableColumn" style={{height: 2000}}/>
                            </div>
                        </Scrollbars>
                    </div>
                    <div className="ControlPanel"/>
                </div>
            </div>
        )
    }
}

export default TableBox;