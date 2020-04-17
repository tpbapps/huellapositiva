import React from 'react';
import './VolunteerLogin.scss';
import { FormLoginVolunteer } from '../../components/molecules/FormLoginVolunteer';
import { Link } from 'react-router-dom';

const VolunteerLogin: React.FC = () => {
  return (
    <div className="VolunteerLogin">
      <div className={'header'}>
        <Link to={'/'}> {'<- Inicio'}</Link>
        <Link to={'/volunteer-register'}> {'Registrarse ->'}</Link>
      </div>

      <hr/>

      <div className="container">
        <FormLoginVolunteer/>
      </div>
    </div>
  );
};

export default VolunteerLogin;
