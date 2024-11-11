
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManagementOrderManager from "./components/listers/OrderManagementOrderCards"
import OrderManagementOrderDetail from "./components/listers/OrderManagementOrderDetail"

import ProductionManagementProductionManager from "./components/listers/ProductionManagementProductionCards"
import ProductionManagementProductionDetail from "./components/listers/ProductionManagementProductionDetail"

import LogisticsManagementLogisticsManager from "./components/listers/LogisticsManagementLogisticsCards"
import LogisticsManagementLogisticsDetail from "./components/listers/LogisticsManagementLogisticsDetail"

import SalesManagementSalesManager from "./components/listers/SalesManagementSalesCards"
import SalesManagementSalesDetail from "./components/listers/SalesManagementSalesDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderManagements/orders',
                name: 'OrderManagementOrderManager',
                component: OrderManagementOrderManager
            },
            {
                path: '/orderManagements/orders/:id',
                name: 'OrderManagementOrderDetail',
                component: OrderManagementOrderDetail
            },

            {
                path: '/productionManagements/productions',
                name: 'ProductionManagementProductionManager',
                component: ProductionManagementProductionManager
            },
            {
                path: '/productionManagements/productions/:id',
                name: 'ProductionManagementProductionDetail',
                component: ProductionManagementProductionDetail
            },

            {
                path: '/logisticsManagements/logistics',
                name: 'LogisticsManagementLogisticsManager',
                component: LogisticsManagementLogisticsManager
            },
            {
                path: '/logisticsManagements/logistics/:id',
                name: 'LogisticsManagementLogisticsDetail',
                component: LogisticsManagementLogisticsDetail
            },

            {
                path: '/salesManagements/sales',
                name: 'SalesManagementSalesManager',
                component: SalesManagementSalesManager
            },
            {
                path: '/salesManagements/sales/:id',
                name: 'SalesManagementSalesDetail',
                component: SalesManagementSalesDetail
            },



    ]
})
