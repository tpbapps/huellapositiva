import React from 'react';
import './VolunteerRegister.scss';
import { FormRegisterVolunteer } from '../../components/molecules/FormRegisterVolunteer';
import { Link } from 'react-router-dom';

const VolunteerRegister: React.FC = () => {
  return (
    <div className="VolunteerRegister">
      <div className={'header'}>
        <Link to={'/'}> {'<- Inicio'}</Link>
        <Link to={'/volunteer-login'}> {'Acceder ->'}</Link>
      </div>

      <hr/>

      <div className="container">
        <FormRegisterVolunteer/>
      </div>
    </div>
  );
};

export default VolunteerRegister;
