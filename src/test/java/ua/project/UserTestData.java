package ua.project;

import ua.project.matcher.ModelMatcher;
import ua.project.model.Role;
import ua.project.model.User;

import java.util.Objects;

import static ua.project.model.BaseEntity.START_SEQ;

/**
 * Created by naum_ on 15-Jun-17.
 */
public class UserTestData {

    public static final int ADMIN_ID = START_SEQ;
    public static final int USER_ID = START_SEQ + 1;
    public static final int USER2_ID = START_SEQ + 2;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User USER2 = new User(USER2_ID, "User2", "user2@yandex.ru", "password2", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    public static final ModelMatcher<User> MATCHER = new ModelMatcher<>(
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getPassword(), actual.getPassword())
                            && Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                            && Objects.equals(expected.getEmail(), actual.getEmail())
                            && Objects.equals(expected.getRoles(), actual.getRoles())
                    )
    );

    public static User getCreatedUser(){
        return new User(null, "New", "new@gmail.com", "newPass", Role.ROLE_USER);
    }
}
