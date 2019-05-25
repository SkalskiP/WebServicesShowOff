import React from "react";
import './NavigationBarFooter.scss';
import {AppState} from "../../store";
import {connect} from "react-redux";

interface IProps {
    name: string;
    surname: string;
    avatar: any;
}

const NavigationBarFooterComponent = (props: IProps) => {
    return (
        <div className="NavigationBarFooter">
            <div className="LogoutButton">
                <img alt={"logout"} src={"/ico/logout.png"}/>
            </div>

            <div className="Avatar">
                <img alt={"avatar"} src={"/ico/avatar.png"}/>
            </div>

            <span>
                {props.name + " " + props.surname}
            </span>
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    name: state.account.name,
    surname: state.account.surname,
    avatar: state.account.avatar,
});

export const NavigationBarFooter = connect(
    mapStateToProps,
)(NavigationBarFooterComponent);