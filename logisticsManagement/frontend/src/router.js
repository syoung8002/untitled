import Vue from 'vue'
import Router from 'vue-router'

import LogisticsManagementLogisticsManager from "./components/listers/LogisticsManagementLogisticsCards"
import LogisticsManagementLogisticsDetail from "./components/listers/LogisticsManagementLogisticsDetail"


Vue.use(Router);

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        { 
            path: '/logisticsManagements/logistics',
            name: 'LogisticsManagementLogisticsManager',
            component: LogisticsManagementLogisticsManager,
        },
        {
            path: '/logisticsManagements/logistics/:id',
            name: 'LogisticsManagementLogisticsDetail',
            component: LogisticsManagementLogisticsDetail,
        },
    ]
})
