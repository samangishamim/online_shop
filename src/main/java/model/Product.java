package model;

import Base.Model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults (level = AccessLevel.PRIVATE)

public class Product extends BaseEntity<Integer> {
    Integer id;
    String productName;
    int categoryId;
    int stockQuantity;
    BigDecimal productPrice;
    int brandId;

    public  Product (int id , String productName,int categoryId,int stockQuantity,BigDecimal productPrice,int brandId){
        this.id=id;
        this.productName=productName;
        this.categoryId=categoryId;
        this.stockQuantity=stockQuantity;
        this.productPrice=productPrice;
        this.brandId=brandId;
    }


}
