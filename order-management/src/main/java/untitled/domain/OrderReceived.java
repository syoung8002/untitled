package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderReceived extends AbstractEvent {

    public OrderReceived(Order aggregate) {
        super(aggregate);
    }

    public OrderReceived() {
        super();
    }
}
//>>> DDD / Domain Event
