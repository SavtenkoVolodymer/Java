import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private List<Person> friends;

    public Person(String name) {
        this.name = name;
        this.friends = new ArrayList<Person>();
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
    public void addFriend(Person friend) {
        friends.add(friend);
    }

    public void removeFriend(Person friend) {
        friends.remove(friend);

    }

    public static Set<String> getUniqueFriendsNames (List<Person> persons) {
        return persons.stream()
                .flatMap(person -> person.getFriends().stream())
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }
}

