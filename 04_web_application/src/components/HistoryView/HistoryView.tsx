import React from 'react';
import './HistoryView.scss';
import {HistoryTabName} from "../../utils/types/HistoryTabName";
import TableBox from "../TableBox/TableBox";
import {AppState} from "../../store";
import {connect} from "react-redux";

interface IProps {
    activeHistoryTabName: HistoryTabName;
}

class HistoryViewComponent extends React.Component<IProps, {}> {

    public render() {
        return(
            <div className="HistoryView">
                <TableBox
                    columnWidth={200}
                    headerLabels={["Id", "Street", "Number", "Ticket type", "Start date", "End date", "Status"]}
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