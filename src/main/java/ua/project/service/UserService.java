package ua.project.service;

import org.springframework.transaction.annotation.Transactional;
import ua.project.model.User;

import java.util.List;

/**
 * Created by naum_ on 13-Jun-17.
 */
@Transactional(readOnly = true)
public interface UserService {

    User save(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();
}
