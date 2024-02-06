package model;

import Base.Model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ShoppingCart extends BaseEntity<Integer> {
    int productId;
    int quantity;
    BigDecimal price;
    BigDecimal totalAmount;
    java.sql.Date orderDate;
    int userId;

    public ShoppingCart (int id, int productId, int quantity, BigDecimal price, BigDecimal totalAmount, Date orderDate, int userId){
        super(id);
        this.productId=productId;
        this.quantity=quantity;
        this.price=price;
        this.orderDate=orderDate;
        this.userId=userId;
    }
}
