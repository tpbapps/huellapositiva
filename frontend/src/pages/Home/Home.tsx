import React from 'react';
import './Home.scss';
import { LinkButton } from '../../components/atoms/LinkButton/LinkButton';


export const Home: React.FC<{}> = () => {
  return (
    <div className={'Home'}>
      <LinkButton path={'/volunteer-register'} text={'Registrar voluntario'}/>
      <LinkButton path={'/volunteer-login'} text={'Acceso voluntario'}/>
    </div>
  );
};
