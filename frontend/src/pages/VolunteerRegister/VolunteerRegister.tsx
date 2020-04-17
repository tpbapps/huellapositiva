import React from 'react';
import './VolunteerRegister.scss';
import { FormRegisterVolunteer } from '../../components/molecules/FormRegisterVolunteer';

const VolunteerRegister: React.FC = () => {
  return (
    <div className="VolunteerRegister">
      <FormRegisterVolunteer/>
    </div>
  );
};

export default VolunteerRegister;
