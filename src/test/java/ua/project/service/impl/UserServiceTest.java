package ua.project.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.project.model.Role;
import ua.project.model.User;
import ua.project.service.AbstractServiceTest;
import ua.project.service.UserService;

import java.util.Arrays;
import java.util.Collection;

import static ua.project.UserTestData.*;

/**
 * Created by naum_ on 15-Jun-17.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void save() throws Exception {
        //create
        User newUser = getCreatedUser();
        User created = service.save(newUser);
        newUser.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, newUser, USER, USER2), service.getAll());
        //update
        newUser.setEmail("updated@gmail.com");
        service.save(newUser);
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, newUser, USER, USER2), service.getAll());
    }

    @Test
    public void delete() throws Exception {
        service.delete(USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER2), service.getAll());
    }

    @Test
    public void get() throws Exception {
        User user = service.get(USER_ID);
        MATCHER.assertEquals(USER, user);
    }

    @Test
    public void getAll() throws Exception {
        Collection<User> all = service.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER, USER2), all);
    }

}