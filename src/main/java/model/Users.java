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
public class Users extends BaseEntity<Integer> {
    String username;
    String password;

    public Users (int id,String username,String password){
        super(id);
        this.username=username;
        this.password=password;
    }
}
