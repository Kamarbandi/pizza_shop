import React from 'react';
import { Link } from 'react-router-dom';

import cartEmptyImg from '../assets/img/empty-cart.png';

const CartEmpty = () => (
    <div className="cart cart--empty">
        <h2>
            Basket is empty <span>😕</span>
        </h2>
        <p>
            Most likely, you haven't ordered pizza yet.
            <br />
            To order pizza, go to the main page. You haven't ordered pizza yet.
        </p>
        <img src={cartEmptyImg} alt="Empty cart" />
        <Link to="/" className="button button--black">
            <span>Go back</span>
        </Link>
    </div>
)

export default CartEmpty;