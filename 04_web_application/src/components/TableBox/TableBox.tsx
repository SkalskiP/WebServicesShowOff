import React from 'react';
import './TableBox.scss';
import  Scrollbars  from 'react-custom-scrollbars';

interface IProps {
    tableWidth: number;
    renderHeader: (style: React.CSSProperties) => any;
    headerHeight:number;
    renderContent: (style: React.CSSProperties) => any;
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

    protected resizeTable = ():void => {
        const tableWrapperSize = this.tableWrapper.getBoundingClientRect();

        this.setState({
            tableWidth: Math.min(this.props.tableWidth, tableWrapperSize.width),
            tableHeight: tableWrapperSize.height
        });
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
        console.log(this.state.tableWidth);
        return(
            <div className="TableBoxWrapper" ref={ref => this.tableWrapper = ref}>
                <div className="TableBox" style={{width: tableWidth, height: tableHeight}}>
                    <div className="HeaderWrapper" style={{height: this.props.headerHeight}}>
                        {this.props.renderHeader({width: this.props.tableWidth, left: tableLeftOffset})}
                    </div>
                    <div className="TableWrapper">
                        <Scrollbars
                            onScrollFrame={this.handleScrollFrame}
                            autoHide={true}
                        >
                            {this.props.renderContent({width: this.props.tableWidth})}
                        </Scrollbars>
                    </div>
                    <div className="ControlPanel"/>
                </div>
            </div>
        )
    }
}

export default TableBox;