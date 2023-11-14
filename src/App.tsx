import React, { FC, useState } from 'react';
import AddPizzaForm from './components/AddPizzaForm';
import DisplayPizzas from './components/DisplayPizzas';
import Pizza from './models/Pizza';
import './App.css';



const App: FC = () => {
  const [pizzasList, setPizzaList] = useState<Pizza[]>([]);


  const addPizza = (newPizza: Pizza) => {
      setPizzaList([...pizzasList, newPizza]);
  }

  const updatePizza = (newPizza: Pizza) => {
      setPizzaList(pizzasList.map((pizza) => 
          (pizza.id === newPizza.id ? newPizza : pizza)
      ));
  }  

  const deletePizza = (id: number) => {
    const newPizzasList = pizzasList.filter(pizza => pizza.id !== id);
    setPizzaList(newPizzasList);
  }


console.log('pizzaList >>> ', pizzasList);


  return (
    <div className="App">
      <div className="wrap">
          <span className='heading'>Our Pizzaria</span>
          <AddPizzaForm
            addPizza={addPizza}
          />

          <DisplayPizzas
            pizzasList={pizzasList}
            deletePizza={deletePizza}
            updatePizza={updatePizza}
          />
      </div>
    </div>
  );
}

export default App;
