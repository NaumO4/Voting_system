package ua.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ua.project.model.User;
import ua.project.repository.UserRepository;
import ua.project.service.UserService;

import java.util.List;

import static ua.project.util.ValidationUtil.checkNotFoundWithId;

/**
 * Created by naum_ on 14-Jun-17.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private static final Sort SORT_NAME = new Sort(Sort.Direction.ASC,"name");

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public User save(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) {
        return checkNotFoundWithId(repository.findOne(id), id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll(SORT_NAME);
    }
}
