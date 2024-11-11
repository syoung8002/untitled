import Vue from 'vue'
import Router from 'vue-router'

import OrderManagementOrderManager from "./components/listers/OrderManagementOrderCards"
import OrderManagementOrderDetail from "./components/listers/OrderManagementOrderDetail"


Vue.use(Router);

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        { 
            path: '/orderManagements/orders',
            name: 'OrderManagementOrderManager',
            component: OrderManagementOrderManager,
        },
        {
            path: '/orderManagements/orders/:id',
            name: 'OrderManagementOrderDetail',
            component: OrderManagementOrderDetail,
        },
    ]
})
