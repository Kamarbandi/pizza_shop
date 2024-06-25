import Header from "../components/Header";
import React from "react";
import { Outlet } from "react-router-dom"

const ParentLayout: React.FC = () => {
    return (
        <>
            <div className="wrapper">
                    <Header/>
                <div className="content">
                    <Outlet/>
                </div>
            </div>
        </>
    )
}

export default ParentLayout;