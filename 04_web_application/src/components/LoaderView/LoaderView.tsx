import React from 'react';
import {RotateLoader} from 'react-spinners';
import './LoaderView.scss';

export const LoaderView: React.FC<{}> = () => {
  return (
    <div className="LoaderView">
      <RotateLoader color={'#7bd4d7'} loading={true} />
    </div>
  );
};
