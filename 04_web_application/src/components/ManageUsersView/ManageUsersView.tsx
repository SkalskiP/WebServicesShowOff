import axios from 'axios';
import classnames from 'classnames';
import { User } from 'firebase';
import React, { useEffect, useState } from 'react';
import Settings from '../../settings/Settings';
import { UserData } from '../../utils/types/UserData';
import AccountSettingsView from '../AccountSettingsView/AccountSettingsView';
import TableBox from '../TableBox/TableBox';
import { TextButton } from '../TextButton/TextButton';
import './ManageUsersView.scss';

export const ManageUsersView: React.FC<{}> = () => {
  const [tableData, setTableData] = useState<UserData[]>([]);
  const [editedUser, setEditedUser] = useState<UserData | undefined>(null);

  useEffect(() => {
    const fetchData = async () => {
      const {data} = await axios.get(Settings.SERVER_NAME + '/auth/rest/user');
      setTableData(data.values);
    };

    fetchData();
  }, [editedUser]);

  const renderHeader = (style: any) => (
    <div className="TableHeader" style={style}>
      <div className={classnames('ColumnHeader', 'WideTableCell')}>ID</div>
      <div className="ColumnHeader">Name</div>
      <div className={classnames('ColumnHeader', 'WideTableCell')}>Email</div>
      <div className="ColumnHeader">Edit</div>
    </div>
  );

  const renderContent = (style: any) => (
    <div className="TableContent" style={style}>
      {tableData.map((data: UserData) => (
        <div className="TableRow">
          <div className={classnames('TableCell', 'WideTableCell')}>{data.uid}</div>
          <div className="TableCell">{data.displayName}</div>
          <div className={classnames('TableCell', 'WideTableCell')}>{data.email}</div>
          <div className="TableCell">
            <TextButton label={'Edit'} onClick={() => setEditedUser(data)} />
          </div>
        </div>
      ))}
    </div>
  );

  if (!!editedUser)
    return (
      <>
        <div className="BackButtonContainer">
          <TextButton label={'Back'} onClick={() => setEditedUser(undefined)} />
        </div>
        <AccountSettingsView setEditedUser={setEditedUser} editedUser={editedUser} />
      </>
    );
  else
    return (
      <div className="ManageUsersView">
        <TableBox
          totalTableContentWidth={1000}
          renderHeader={renderHeader}
          headerHeight={50}
          renderContent={renderContent}
        />
      </div>
    );
};
