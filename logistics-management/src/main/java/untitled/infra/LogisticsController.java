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
// @RequestMapping(value="/logistics")
@Transactional
public class LogisticsController {

    @Autowired
    LogisticsRepository logisticsRepository;

    @RequestMapping(
        value = "/logistics/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Logistics storeFish(
        @PathVariable(value = "id") String id,
        @RequestBody StoreFishCommand storeFishCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /logistics/storeFish  called #####");
        Optional<Logistics> optionalLogistics = logisticsRepository.findById(
            id
        );

        optionalLogistics.orElseThrow(() -> new Exception("No Entity Found"));
        Logistics logistics = optionalLogistics.get();
        logistics.storeFish(storeFishCommand);

        logisticsRepository.save(logistics);
        return logistics;
    }

    @RequestMapping(
        value = "/logistics/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Logistics requestDelivery(
        @PathVariable(value = "id") String id,
        @RequestBody RequestDeliveryCommand requestDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /logistics/requestDelivery  called #####");
        Optional<Logistics> optionalLogistics = logisticsRepository.findById(
            id
        );

        optionalLogistics.orElseThrow(() -> new Exception("No Entity Found"));
        Logistics logistics = optionalLogistics.get();
        logistics.requestDelivery(requestDeliveryCommand);

        logisticsRepository.save(logistics);
        return logistics;
    }
}
//>>> Clean Arch / Inbound Adaptor
