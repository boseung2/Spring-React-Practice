import './App.css';
import { Route, Switch } from 'react-router';
import BoardListPage from './pages/BoardListPage';
import BoardReadPage from './pages/BoardReadPage';
import BoardRegisterPage from './pages/BoardRegisterPage';
import Home from './pages/Home';
import BoardModifyPage from './pages/BoardModifyPage';

const App = () => {
  return (
    <>
      <Route>
        <Route component={Home} path={'/'} exact />
        <Switch>
          <Route component={BoardModifyPage} path={'/board/register/:bno'} />
          <Route component={BoardRegisterPage} path={'/board/register'} />
          <Route component={BoardReadPage} path={'/board/:bno'} />
          <Route component={BoardListPage} path={'/board'} />
        </Switch>
      </Route>
    </>
  )
};

export default App;
