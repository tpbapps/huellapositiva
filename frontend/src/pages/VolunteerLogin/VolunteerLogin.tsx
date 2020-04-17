import React from 'react';
import './VolunteerLogin.scss';
import { FormLoginVolunteer } from '../../components/molecules/FormLoginVolunteer';

const VolunteerLogin: React.FC = () => {
  return (
    <div className="VolunteerLogin">
      <FormLoginVolunteer/>
    </div>
  );
};

export default VolunteerLogin;
