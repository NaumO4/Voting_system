package ua.project;

import ua.project.model.BaseEntity;

/**
 * Created by naum_ on 13-Jun-17.
 */
public class AuthorizedUser {
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }
}
