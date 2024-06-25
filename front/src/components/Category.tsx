import React from "react";

type CategoryProps = {
    value: number;
    onClickCategory: (i: number) => void;
};

const categories = ['All', 'Meat', 'Vegetarian', 'Grill', 'Spicy', 'Margherita', 'Hawaiian', 'BBQ'];

const Category: React.FC<CategoryProps> = ({ value, onClickCategory }) => {
    return (
        <div className="categories">
            <ul>
                {categories.map((categoryName, index) => (
                    <li
                        key={index}
                        onClick={() => onClickCategory(index)}
                        className={value === index ? 'active' : ''}>
                        {categoryName}
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default Category;