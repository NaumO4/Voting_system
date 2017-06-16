package ua.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.project.model.Restaurant;
import ua.project.model.Vote;
import ua.project.model.VoteCount;

import java.util.List;
import java.util.Map;

/**
 * Created by naum_ on 14-Jun-17.
 */
@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    Vote save(Vote restaurant);

    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    List<Vote> findAll();

    Vote findOne(Integer id);

    void deleteAll();

    @Modifying
    @Query(value = "SELECT new ua.project.model.VoteCount(v.restaurant.id, COUNT (v.id), v.restaurant) FROM Vote v GROUP BY v.restaurant.id ORDER BY COUNT (v.id) DESC ")
    List<VoteCount> getCountVotes();
}
