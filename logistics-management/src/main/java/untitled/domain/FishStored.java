package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FishStored extends AbstractEvent {

    public FishStored(Logistics aggregate) {
        super(aggregate);
    }

    public FishStored() {
        super();
    }
}
//>>> DDD / Domain Event