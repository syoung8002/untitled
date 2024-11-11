package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderProcessed extends AbstractEvent {

    public OrderProcessed(Sales aggregate) {
        super(aggregate);
    }

    public OrderProcessed() {
        super();
    }
}
//>>> DDD / Domain Event
