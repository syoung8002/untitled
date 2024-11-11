package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryRequested extends AbstractEvent {

    public DeliveryRequested(Logistics aggregate) {
        super(aggregate);
    }

    public DeliveryRequested() {
        super();
    }
}
//>>> DDD / Domain Event
