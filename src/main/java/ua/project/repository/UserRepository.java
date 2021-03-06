package ua.project.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.project.model.User;

import java.util.List;

/**
 * Created by naum_ on 13-Jun-17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    User save(User user);

    @Override
    User findOne(Integer integer);

    @Override
    List<User> findAll(Sort sort);
}
