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

public class Admins extends BaseEntity<String> {
    String username;
    String password;

}
