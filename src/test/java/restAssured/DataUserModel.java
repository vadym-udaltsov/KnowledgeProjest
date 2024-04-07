
package restAssured;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataUserModel {

    private String avatar;
    private String email;
    private String first_name;
    private Long id;
    private String last_name;
}
