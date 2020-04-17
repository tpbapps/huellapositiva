import React from 'react';

const VolunteerLogin: React.FC = () => {
  return (
    <div className="VolunteerLogin">
        <h1>Acceso voluntario</h1>
        <form>
          <label>Email:</label>
          <input type="email" name="email"/>
          <br/>

          <label>Contraseña:</label>
          <input type="password" name="password"/>
          <br/>

          <button>Acceder</button>
        </form>
    </div>
  );
};

export default VolunteerLogin;
