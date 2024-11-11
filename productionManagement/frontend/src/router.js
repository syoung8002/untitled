import Vue from 'vue'
import Router from 'vue-router'

import ProductionManagementProductionManager from "./components/listers/ProductionManagementProductionCards"
import ProductionManagementProductionDetail from "./components/listers/ProductionManagementProductionDetail"


Vue.use(Router);

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        { 
            path: '/productionManagements/productions',
            name: 'ProductionManagementProductionManager',
            component: ProductionManagementProductionManager,
        },
        {
            path: '/productionManagements/productions/:id',
            name: 'ProductionManagementProductionDetail',
            component: ProductionManagementProductionDetail,
        },
    ]
})
