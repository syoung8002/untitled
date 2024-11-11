package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/sales")
@Transactional
public class SalesController {

    @Autowired
    SalesRepository salesRepository;

    @RequestMapping(
        value = "/sales/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Sales updateContractInfo(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateContractInfoCommand updateContractInfoCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /sales/updateContractInfo  called #####");
        Optional<Sales> optionalSales = salesRepository.findById(id);

        optionalSales.orElseThrow(() -> new Exception("No Entity Found"));
        Sales sales = optionalSales.get();
        sales.updateContractInfo(updateContractInfoCommand);

        salesRepository.save(sales);
        return sales;
    }

    @RequestMapping(
        value = "/sales/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Sales processOrder(
        @PathVariable(value = "id") String id,
        @RequestBody ProcessOrderCommand processOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /sales/processOrder  called #####");
        Optional<Sales> optionalSales = salesRepository.findById(id);

        optionalSales.orElseThrow(() -> new Exception("No Entity Found"));
        Sales sales = optionalSales.get();
        sales.processOrder(processOrderCommand);

        salesRepository.save(sales);
        return sales;
    }
}
//>>> Clean Arch / Inbound Adaptor
