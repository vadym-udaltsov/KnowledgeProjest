
package restAssured.models.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuccessRegisterModel {
    private String id;
    private String token;
}
