import React from 'react';
import './ContentContainer.scss';
import {ContentContainerHeader} from "../ContentContainerHeader/ContentContainerHeader";

const ContentContainer: React.FC = () => {
    return (
        <div className="ContentContainer">
            <ContentContainerHeader/>
        </div>
    );
};

export default ContentContainer;