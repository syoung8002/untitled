import { registerApplication, start } from 'single-spa';
import {
  constructApplications,
  constructRoutes,
  constructLayoutEngine,
} from 'single-spa-layout';

const routes = constructRoutes(`
<single-spa-router mode="hash" base="/">
  <route default>
    <application name="@my-app/home"></application>
  </route>
  <route path="orderManagements">
    <application name="@my-app/order-management"></application>
  </route>
  <route path="productionManagements">
    <application name="@my-app/production-management"></application>
  </route>
  <route path="logisticsManagements">
    <application name="@my-app/logistics-management"></application>
  </route>
  <route path="salesManagements">
    <application name="@my-app/sales-management"></application>
  </route>
</single-spa-router>
`);

const applications = constructApplications({
  routes,
  loadApp({ name }) {
    return System.import(name);
  },
});

const layoutEngine = constructLayoutEngine({ routes, applications });

applications.forEach(registerApplication);
layoutEngine.activate();
start();