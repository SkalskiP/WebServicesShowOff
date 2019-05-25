import React from 'react';
import './ContentContainer.scss';
import {ContentContainerHeader} from "../ContentContainerHeader/ContentContainerHeader";
import RoundBox from "../RoundBox/RoundBox";

const ContentContainer: React.FC = () => {
    return (
        <div className="ContentContainer">
            <ContentContainerHeader/>
            <RoundBox/>
        </div>
    );
};

export default ContentContainer;