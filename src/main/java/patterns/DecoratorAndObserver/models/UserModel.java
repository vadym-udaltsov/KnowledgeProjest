package patterns.DecoratorAndObserver.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {
    private Integer age;
    private String name;
    private String email;
    private String userName;
    private String password;
}
