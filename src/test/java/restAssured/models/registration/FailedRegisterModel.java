
package restAssured.models.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FailedRegisterModel {
    private String error;
}
