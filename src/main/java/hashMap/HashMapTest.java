package hashMap;

import java.util.HashMap;
import java.util.stream.Collectors;

public class HashMapTest {
    public static void main(String[] args) {
        var map = new HashMap<UserModelForHashMap, String>();
        var firstUser = UserModelForHashMap.builder().name("Nekita").build();
        var secondUser = UserModelForHashMap.builder().name("Vova").build();
        var thirdUser = UserModelForHashMap.builder().name("Nekita").build();
        map.put(firstUser, "firstUser");
        map.put(secondUser, "secondUser");
        map.put(thirdUser, "firstUser");
        System.out.println(map);
        System.out.println(map.entrySet()
                .stream()
                .filter(v -> v.getValue().equalsIgnoreCase("firstUser"))
                .map(v -> v.getKey().getName())
                .collect(Collectors.toList()));
    }
}
