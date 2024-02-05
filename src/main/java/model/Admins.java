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

public class Admins extends BaseEntity<Integer> {
    String username;
    String password;

    public  Admins(int id , String username , String password){
        super(id);
        this.username=username;
        this.password=password;
    }

}
