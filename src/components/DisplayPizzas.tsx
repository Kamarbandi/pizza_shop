import React, { FC } from 'react';
import SinglePizza from './SinglePizza';
import Pizza from '../models/Pizza';

interface DisplayPizzasProps {
    pizzasList: Pizza[];
    deletePizza: (id: number) => void;
    updatePizza: (newPizza: Pizza) => void;
}


const DisplayPizzas: FC<DisplayPizzasProps> = 
({ pizzasList, deletePizza, updatePizza }) => {
    return (
        <div className='container'>
            {pizzasList.map((pizza) => {
            return <SinglePizza 
                    key={pizza.id}
                    deletePizza={deletePizza}
                    updatePizza={updatePizza}
                    pizza={pizza}
                    />
                })}
        </div>
    )
}


export default DisplayPizzas;