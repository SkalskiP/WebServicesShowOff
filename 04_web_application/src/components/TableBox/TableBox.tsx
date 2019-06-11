import React from 'react';
import './TableBox.scss';
import  Scrollbars  from 'react-custom-scrollbars';

interface IProps {
    totalTableContentWidth: number;
    renderHeader: (style: React.CSSProperties) => any;
    headerHeight:number;
    renderContent?: (style: React.CSSProperties) => any;
    renderFooter?: (style: React.CSSProperties) => any;
    noDataMessage?: string;
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
            tableWidth: Math.min(this.props.totalTableContentWidth, tableWrapperSize.width),
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
        const {headerHeight, renderHeader, totalTableContentWidth, renderContent, renderFooter, noDataMessage} = this.props;
        return(
            <div className="TableBoxWrapper" ref={ref => this.tableWrapper = ref}>
                <div className="TableBox" style={{width: tableWidth, height: tableHeight}}>
                    <div className="HeaderWrapper" style={{height: headerHeight}}>
                        {renderHeader({width: totalTableContentWidth, left: tableLeftOffset})}
                    </div>
                    <div className="TableWrapper">
                        {!!renderContent ? <Scrollbars
                            onScrollFrame={this.handleScrollFrame}
                            autoHide={true}
                        >
                            {renderContent({width: totalTableContentWidth - 1})}
                        </Scrollbars> : noDataMessage}
                    </div>
                    <div className="ControlPanel">
                        {renderFooter && renderFooter({})}
                    </div>
                </div>
            </div>
        )
    }
}

export default TableBox;