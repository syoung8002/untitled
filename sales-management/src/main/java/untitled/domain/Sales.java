package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.SalesManagementApplication;

@Entity
@Table(name = "Sales_table")
@Data
//<<< DDD / Aggregate Root
public class Sales {

    @Id
    private String salesId;

    private String customerId;

    private String contractStatus;

    @Embedded
    private contractStatusType contractStatusType;

    @PrePersist
    public void onPrePersist() {}

    public static SalesRepository repository() {
        SalesRepository salesRepository = SalesManagementApplication.applicationContext.getBean(
            SalesRepository.class
        );
        return salesRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateContractInfo(
        UpdateContractInfoCommand updateContractInfoCommand
    ) {
        //implement business logic here:

        ContractInfoUpdated contractInfoUpdated = new ContractInfoUpdated(this);
        contractInfoUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void processOrder(ProcessOrderCommand processOrderCommand) {
        //implement business logic here:

        OrderProcessed orderProcessed = new OrderProcessed(this);
        orderProcessed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
