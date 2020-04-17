import React from 'react';

const AdminLogin: React.FC = () => {
  return (
    <div className="AdminLogin">
        <h1>Acceso administrador</h1>
        <form>
          <label>Usuaria o usuario:</label>
          <input type="text" name="username"/>
          <br/>

          <label>Contraseña:</label>
          <input type="password" name="password"/>
          <br/>

          <button>Acceder</button>
        </form>
    </div>
  );
};

export default AdminLogin;
