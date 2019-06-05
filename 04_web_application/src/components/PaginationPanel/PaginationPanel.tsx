import React from "react";
import './PaginationPanel.scss';
import {TextButton} from "../TextButton/TextButton";
import ImageButton from "../ImageButton/ImageButton";

interface IProps {
    activePageIndex: number;
    totalPagesCount:number;
    onActivePageChange: (activePageIndex:number) => any;
}

const PaginationPanel = (props:IProps) => {
    const PAGINATION_RANGE:number = 2;
    const {activePageIndex, totalPagesCount, onActivePageChange} = props;
    const showLeftArrow:boolean = activePageIndex !== 1;
    const showRightArrow:boolean = activePageIndex !== totalPagesCount;
    const lowerPaginationIndex:number = Math.max(1, activePageIndex - PAGINATION_RANGE);
    const upperPaginationIndex:number = Math.min(totalPagesCount, activePageIndex + PAGINATION_RANGE);

    const getPaginationButtons = () => {
        let buttons = [];
        for (let index = lowerPaginationIndex; index <= upperPaginationIndex; index++) {
            buttons.push(<TextButton
                label={"" + index}
                onClick={() => clickHandle(index)}
                isActive={index === activePageIndex}
            />)
        }
        return buttons;
    };

    const clickHandle = (index: number) => {
        if (index !== props.activePageIndex) {
            props.onActivePageChange(index);
        }
    };

    return (
        <div className="PaginationPanel">
            {showLeftArrow && <ImageButton
                key={"left"}
                image={"ico/arrow_left.png"}
                imageAlt={"arrow_left"}
                isActive={false}
                onClick={() => clickHandle(activePageIndex - 1)}
            />}
            {getPaginationButtons()}
            {showRightArrow && <ImageButton
                key={"right"}
                image={"ico/arrow_right.png"}
                imageAlt={"arrow_right"}
                isActive={false}
                onClick={() => clickHandle(activePageIndex + 1)}
            />}
        </div>
    );
};

export default PaginationPanel;