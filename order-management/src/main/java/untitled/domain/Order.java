package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.OrderManagementApplication;
import untitled.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    private String orderId;

    private String customerId;

    private String productId;

    private String orderStatus;

    @Embedded
    private orderStatusType orderStatusType;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderManagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void receiveOrder(ReceiveOrderCommand receiveOrderCommand) {
        //implement business logic here:

        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
