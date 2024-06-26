import React from "react";
import {useNavigate, useParams} from 'react-router-dom';
import axios from "axios";

const FullPizza = () => {
    const [pizza, setPizza] = React.useState<{
        imageUrl: string,
        title:string,
        price: number
    }>();

    const { id } = useParams();
    const navigate = useNavigate();

    React.useEffect(() => {
        async function fetchPizza() {
            try {
                const { data } = await axios.get("https://663231d1c51e14d69563a7b4.mockapi.io/items/" + id);
                setPizza(data);
            } catch (error) {
                alert("Something is happen during get Pizza");
                navigate('/');
            }
        }

        fetchPizza();
    }, []);

    if (!pizza) {
        return "Download ...";
    }

    return (
        <div className='container'>
            <img src={pizza.imageUrl}/>
            <h1>{pizza.title}</h1>
            <p>{pizza.price} €</p>
        </div>
    )
}

export default FullPizza;