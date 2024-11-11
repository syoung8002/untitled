package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ContractInfoUpdated extends AbstractEvent {

    public ContractInfoUpdated(Sales aggregate) {
        super(aggregate);
    }

    public ContractInfoUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
