package hashMap;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModelForHashMap {
    private Integer age;
    private String name;
    private String email;
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "UserModel{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    // Если equals and hashcode не переопределён, то при добавлении двух одинаковых обьектов в HashMap, будет коллизия, когда будут 2 ключа с 1 значением
    // {UserModel{age=null, name='Nekita', email='null', userName='null', password='null'}=firstUser,
    // UserModel{age=null, name='Nekita', email='null', userName='null', password='null'}=firstUser }


    // Если переопределить, то в HashMap будет только 1 ключ и 1 значение
    // {UserModel{age=null, name='Nekita', email='null', userName='null', password='null'}=firstUser }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModelForHashMap)) return false;
        UserModelForHashMap userModel = (UserModelForHashMap) o;
        return Objects.equals(getAge(), userModel.getAge()) && Objects.equals(getName(), userModel.getName()) && Objects.equals(getEmail(), userModel.getEmail()) && Objects.equals(getUserName(), userModel.getUserName()) && Objects.equals(getPassword(), userModel.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getEmail(), getUserName(), getPassword());
    }
}
