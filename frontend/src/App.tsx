import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import VolunteerLogin from './pages/VolunteerLogin';
import AdminLogin from './pages/AdminLogin';

const App: React.FC = () => {
  return (
    <div className="App">
      <Router>
        <section className="section">
          <div className="container">
            <div className="columns">
              <div className="column">
                <h1 className="title">
                  <Link to="/volunteer-login">Acceso Voluntarios</Link>
                </h1>
              </div>
              <div className="column">
                <h1 className="title">
                  <Link to="/admin-login">Acceso Administrador</Link>
                </h1>
              </div>
            </div>
          </div>

          <hr />

          <div className="container">
            <div className="notification">
              <h3 className="subtitle">
                TODO: Hacer portada con dos opciones nada mas, acceso voluntario o acceso
                administrador
              </h3>
            </div>

            <Switch>
              <Route exact path="/volunteer-login">
                <VolunteerLogin />
              </Route>
              <Route path="/admin-login">
                <AdminLogin />
              </Route>
            </Switch>
          </div>
        </section>
      </Router>
    </div>
  );
};

export default App;
