package model;

import Base.Model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand extends BaseEntity<Integer> {
    String brandName;

    public  Brand (int id,String brandName ){
        super(id);
        this.brandName=brandName;
    }
}
