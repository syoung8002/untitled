package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductionRequestReceived extends AbstractEvent {

    public ProductionRequestReceived(Production aggregate) {
        super(aggregate);
    }

    public ProductionRequestReceived() {
        super();
    }
}
//>>> DDD / Domain Event
