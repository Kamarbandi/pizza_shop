import {Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import NotFound from "./pages/NotFound";
import Cart from "./pages/Cart";
import FullPizza from "./pages/FullPizza";
import ParentLayout from "./layout/ParentLayout";
import './scss/app.scss'

const App = () => {
    return (
        <Routes>
            <Route path="/" element={ <ParentLayout/> }>
                <Route path="" element={<Home />} />
                <Route path="cart" element={<Cart />} />
                <Route path="pizza/:id" element={<FullPizza />} />
                <Route path="*" element={<NotFound  />} />
            </Route>
        </Routes>
    );
}

export default App;
