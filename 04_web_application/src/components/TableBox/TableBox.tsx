import React from 'react';
import './TableBox.scss';
import  Scrollbars  from 'react-custom-scrollbars';

const TableBox: React.FC = () => {
    return (
        <div className="TableBox">
            <div className="TableWrapper">
                <Scrollbars>
                    <div className="TableContent">
                        <div className="TableColumn" style={{height: 2000}}>
                            <div className="ColumnHeader">
                                Id
                            </div>
                        </div>
                        <div className="TableColumn" style={{height: 2000}}>
                            <div className="ColumnHeader">
                                Street
                            </div>
                        </div>
                        <div className="TableColumn" style={{height: 2000}}>
                            <div className="ColumnHeader">
                                Number
                            </div>
                        </div>
                        <div className="TableColumn" style={{height: 2000}}>
                            <div className="ColumnHeader">
                                Start time
                            </div>
                        </div>
                        <div className="TableColumn" style={{height: 2000}}>
                            <div className="ColumnHeader">
                                End time
                            </div>
                        </div>
                        <div className="TableColumn" style={{height: 2000}}>
                            <div className="ColumnHeader">
                                Ticket type
                            </div>
                        </div>
                        <div className="TableColumn" style={{height: 2000}}>
                            <div className="ColumnHeader">
                                Status
                            </div>
                        </div>
                    </div>
                </Scrollbars>
            </div>
            <div className="ControlPanel"/>
        </div>
    );
};

export default TableBox;