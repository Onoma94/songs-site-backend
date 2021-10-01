import { BrowserRouter, Route, Switch } from "react-router-dom";

import Home from "../pages/home";
import Chart from "../pages/chart";
import Songs from "../pages/songs";
import Blog from "../pages/blog";
import Contact from "../pages/contact";

const Router = () => {
    return (
      <div className="wrapper">
        <BrowserRouter>
          <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            <Route path="/chart">
              <Chart />
            </Route>
            <Route path="/songs">
              <Songs />
            </Route>
            <Route path="/blog">
              <Blog />
            </Route>
            <Route path="/contact">
              <Contact />
            </Route>
          </Switch>
        </BrowserRouter>
      </div>
    );
  };
  
  export default Router;