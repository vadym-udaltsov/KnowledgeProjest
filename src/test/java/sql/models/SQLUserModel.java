package sql.models;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class SQLUserModel {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String email;

    @Override
    public String toString() {
        return "SQLUserModel{ " +
                "id: " + id +
                ", name: " + name +
                ", age: " + age +
                ", email: " + email +
                " }";
    }
}
