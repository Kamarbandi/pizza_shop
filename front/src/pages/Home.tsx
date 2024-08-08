import React from "react";
import qs from "qs";
import {Link, useNavigate} from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux'
import FilterSlice, {
    FilterState,
    selectFilter,
    setCategoryId,
    setCurrentPage,
    setFilters
} from '../redux/slices/filterSlice';
import {getPizzas, SearchPizzaParams, selectPizzaData} from '../redux/slices/pizza';
import Category from "../components/Category";
import Sorting, {list} from "../components/Sorting";
import Skeleton from "../components/PizzaBlock/Skeleton";
import PizzaBlock from "../components/PizzaBlock";
import Pagination from "../components/Pagination";
import {useAppDispatch} from "../redux/store";

const Home: React.FC = () => {
    const userNavigate = useNavigate();
    const dispatch = useAppDispatch();

    const { items, status, totalPages } = useSelector(selectPizzaData);
    const {categoryId, sort, currentPage, searchValue } = useSelector(selectFilter);

    console.log(totalPages);

    const isSearch = React.useRef(false);
    const isMounted = React.useRef(false);

    const onChangeCategory = (id: number) => {
        dispatch(setCategoryId(id));
    }

    const onChangePage = (page: number) => {
        dispatch(setCurrentPage(page))
    }

    const fetchPizzas = async () => {
        const sortBy = sort.sortProperty.replace('-', '');
        const order = sort.sortProperty.includes('-') ? 'asc' : 'desc';
        const category = categoryId > 0 ? `category=${categoryId}` : '';
        const search = searchValue ? `&search=${searchValue}` : ''

        dispatch(
            getPizzas({
                sortBy,
                order,
                category,
                search,
                currentPage: String(currentPage),
            }),
        );

        window.scroll(0,0);
    }

    // if a parameters was changed and was first request
    React.useEffect( ()=> {
        if (isMounted.current) {
            const queryString = qs.stringify({
                sortProperty: sort.sortProperty,
                categoryId,
                currentPage,
            });

            userNavigate(`?${queryString}`)
        }

        isMounted.current = true;
    }, [categoryId, sort.sortProperty, searchValue, currentPage]);

    // if was a first request, then we will check URL parameters and we save they in redux
    React.useEffect(() => {
        if(window.location.search) {
            const params = qs.parse(window.location.search.substring(1)) as unknown as SearchPizzaParams;

            const sort = list.find((obj) => obj.sortProperty === params.sortBy);

            dispatch(
                setFilters({
                    searchValue: params.search,
                    categoryId: Number(params.category),
                    currentPage: Number(params.currentPage),
                    sort: sort || list[0]
                })
            );
            isSearch.current = true;
        }
    }, []);

    // if was first request then we call all pizzas
    React.useEffect(() => {
        window.scroll(0,0)
        // if(!isSearch.current) {
            fetchPizzas();
        // }

        isSearch.current = false;
    }, [categoryId, sort.sortProperty, searchValue, currentPage]);

    const skeletons = [... new Array(6)].map((_, index) => <Skeleton key={index}/>);

    const pizzas = items.map(
        (obj: any) => (
            <PizzaBlock {...obj }/>
        )
    );

    return (
            <div className="container">
                <div className="content__top">
                    <Category value={categoryId} onClickCategory={ onChangeCategory }/>
                    <Sorting />
                </div>
                <h2 className="content__title">All pizzas</h2>

                {
                    status === 'error' ? (
                        <div className="content__error-info">
                            <h2>
                                Error <span>😕</span>
                            </h2>
                            <p>
                                Unfortunately did not get a Pizzas
                            </p>
                        </div>
                    ) : (
                        <div className="content__items">
                            { status === 'loading' ? skeletons : pizzas }
                        </div>
                    )
                }

                <Pagination pageCount={totalPages} currentPage={currentPage} onChangePage={onChangePage}/>
            </div>
    );
}

export default Home;