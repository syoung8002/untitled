package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.LogisticsManagementApplication;

@Entity
@Table(name = "Logistics_table")
@Data
//<<< DDD / Aggregate Root
public class Logistics {

    @Id
    private String logisticsId;

    private String productId;

    private String deliveryStatus;

    @Embedded
    private deliveryStatusType deliveryStatusType;

    @PrePersist
    public void onPrePersist() {}

    public static LogisticsRepository repository() {
        LogisticsRepository logisticsRepository = LogisticsManagementApplication.applicationContext.getBean(
            LogisticsRepository.class
        );
        return logisticsRepository;
    }

    //<<< Clean Arch / Port Method
    public void storeFish(StoreFishCommand storeFishCommand) {
        //implement business logic here:

        FishStored fishStored = new FishStored(this);
        fishStored.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void requestDelivery(RequestDeliveryCommand requestDeliveryCommand) {
        //implement business logic here:

        DeliveryRequested deliveryRequested = new DeliveryRequested(this);
        deliveryRequested.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
