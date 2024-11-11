import Vue from 'vue'
import Router from 'vue-router'

import SalesManagementSalesManager from "./components/listers/SalesManagementSalesCards"
import SalesManagementSalesDetail from "./components/listers/SalesManagementSalesDetail"


Vue.use(Router);

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        { 
            path: '/salesManagements/sales',
            name: 'SalesManagementSalesManager',
            component: SalesManagementSalesManager,
        },
        {
            path: '/salesManagements/sales/:id',
            name: 'SalesManagementSalesDetail',
            component: SalesManagementSalesDetail,
        },
    ]
})
