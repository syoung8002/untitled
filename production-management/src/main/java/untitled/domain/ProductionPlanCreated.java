package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductionPlanCreated extends AbstractEvent {

    public ProductionPlanCreated(Production aggregate) {
        super(aggregate);
    }

    public ProductionPlanCreated() {
        super();
    }
}
//>>> DDD / Domain Event
