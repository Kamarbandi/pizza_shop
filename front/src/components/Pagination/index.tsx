import React from 'react';
import ReactPaginate from 'react-paginate';

import styles from './Pagination.module.scss';

type PaginationProps = {
    pageCount: number,
    currentPage: number,
    onChangePage: (page: number) => void;
}

 const Pagination: React.FC<PaginationProps> = ({ pageCount, currentPage, onChangePage }) => (
    <ReactPaginate
        className={styles.root}
        breakLabel="..."
        nextLabel=">"
        previousLabel="<"
        onPageChange={(event) => onChangePage(event.selected + 1)}
        pageRangeDisplayed={4}
        pageCount={pageCount}
        forcePage={currentPage - 1}
    />
);

 export default Pagination;