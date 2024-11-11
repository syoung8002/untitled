package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.ProductionManagementApplication;
import untitled.domain.ProductionPlanCreated;

@Entity
@Table(name = "Production_table")
@Data
//<<< DDD / Aggregate Root
public class Production {

    @Id
    private String productionId;

    private String productId;

    private String productionStatus;

    @Embedded
    private productionStatusType productionStatusType;

    @PostPersist
    public void onPostPersist() {
        ProductionPlanCreated productionPlanCreated = new ProductionPlanCreated(
            this
        );
        productionPlanCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProductionRepository repository() {
        ProductionRepository productionRepository = ProductionManagementApplication.applicationContext.getBean(
            ProductionRepository.class
        );
        return productionRepository;
    }

    //<<< Clean Arch / Port Method
    public void requestProduction(
        RequestProductionCommand requestProductionCommand
    ) {
        //implement business logic here:

        ProductionRequestReceived productionRequestReceived = new ProductionRequestReceived(
            this
        );
        productionRequestReceived.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
