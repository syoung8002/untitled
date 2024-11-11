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
// @RequestMapping(value="/productions")
@Transactional
public class ProductionController {

    @Autowired
    ProductionRepository productionRepository;

    @RequestMapping(
        value = "/productions/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Production requestProduction(
        @PathVariable(value = "id") String id,
        @RequestBody RequestProductionCommand requestProductionCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /production/requestProduction  called #####");
        Optional<Production> optionalProduction = productionRepository.findById(
            id
        );

        optionalProduction.orElseThrow(() -> new Exception("No Entity Found"));
        Production production = optionalProduction.get();
        production.requestProduction(requestProductionCommand);

        productionRepository.save(production);
        return production;
    }
}
//>>> Clean Arch / Inbound Adaptor
