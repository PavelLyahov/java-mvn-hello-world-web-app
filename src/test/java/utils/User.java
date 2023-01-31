package utils;

import java.util.Objects;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public int compateTo() {
        return 0;
    }

    public int compareTo(int a) {
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

}
