import axios from "axios";
import {createSlice, createAsyncThunk, PayloadAction} from "@reduxjs/toolkit";
import {RootState} from "../store";
import {Sort} from "./filterSlice";

type PizzaArguments = Record<string, string>;
// this is equal Record<string, string>;
// type PizzaArguments = {
//     sortBy: string;
//     order: string;
//     category: string;
//     search: string;
//     currentPage: string;
// }

type PizzaItem = {
    id:string;
    title:string;
    price: number;
    imageUrl: string;
    sizes:number[];
    types: number[];
    rating: number;
}

export enum Status {
    LOADING = "loading",
    SUCCESS = 'success',
    ERROR = 'error',
}

interface PizzaSliceState {
    items: PizzaItem[];
    status: Status
}

const initialState: PizzaSliceState = {
    items: [],
    status: Status.LOADING, // loading | success | error
}

export type SearchPizzaParams = {
    sortBy: string;
    order: string;
    category: string;
    search: string;
    currentPage: string;
}

export const getPizzas = createAsyncThunk<PizzaItem[], SearchPizzaParams>(
    'pizza/getPizzasStatus',
    async (params) => {
        const { sortBy, order, category, search, currentPage} = params;
        const { data } = await axios.get<PizzaItem[]>(
            `https://663231d1c51e14d69563a7b4.mockapi.io/items?page=${currentPage}&limit=4&${category}&sortBy=${sortBy}&order=${order}${search}`
        );
        return data;
    },
);

export const pizza = createSlice({
    name: 'pizza',
    initialState,
    reducers: {
        setItems(state, action: PayloadAction<PizzaItem[]>) {
            state.items = action.payload;
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(getPizzas.pending, (state) => {
                state.status = Status.LOADING;
                state.items = [];
            })
            .addCase(getPizzas.fulfilled, (state, action) => {
                state.items = action.payload;
                state.status = Status.SUCCESS;
            })
            .addCase(getPizzas.rejected, (state, action) => {
                state.status = Status.ERROR;
                state.items = [];
            });
    },
});

export const selectPizzaData = (state: RootState) => state.pizza;

export const { setItems } = pizza.actions;

export default pizza.reducer;