package model;

import Base.Model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults (level = AccessLevel.PRIVATE)

public class Category extends BaseEntity<Integer> {
    String CategoryName;


    public Category(int id,String categoryName){
        super(id);
        this.CategoryName=categoryName;
    }
}
