import './App.css';
import { Route, Switch } from 'react-router';
import BoardListPage from './pages/BoardListPage';
import BoardPage from './pages/BoardPage';
import BoardRegisterPage from './pages/BoardRegisterPage';
import Home from './pages/Home';

const App = () => {
  return (
    <>
      <Route>
        <Route component={Home} path={'/'} exact />
        <Switch>
          <Route component={BoardRegisterPage} path={'/board/register'} />
          <Route component={BoardPage} path={'/board/:bno'} />
          <Route component={BoardListPage} path={'/board'} />
        </Switch>
      </Route>
    </>
  )
};

export default App;
