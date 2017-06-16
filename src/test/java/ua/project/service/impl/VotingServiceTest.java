package ua.project.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.project.model.Vote;
import ua.project.model.VoteCount;
import ua.project.service.AbstractServiceTest;
import ua.project.service.VotingService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static ua.project.RestaurantTestData.RESTAURANT2;
import static ua.project.UserTestData.ADMIN_ID;
import static ua.project.VoteTestData.*;

/**
 * Created by naum_ on 16-Jun-17.
 */
public class VotingServiceTest extends AbstractServiceTest {

    @Autowired
    private VotingService votingService;

    @Test
    public void save() throws Exception {
        //update
        Vote newVote = new Vote(ADMIN_ID, RESTAURANT2);
        votingService.save(newVote);
        VOTE_MATCHER.assertCollectionEquals(Arrays.asList(VOTE2, VOTE3, newVote), votingService.getAllVotes());
    }

    @Test
    public void getUserVote() throws Exception {
        VOTE_MATCHER.assertEquals(VOTE1,votingService.getUserVote(ADMIN_ID));

    }

    @Test
    public void getVotingResult() throws Exception {
        List<VoteCount> votingResult = votingService.getVotingResult();
        Assert.assertEquals(votingResult.get(0).getId(),Integer.valueOf(100003));
        Assert.assertEquals(votingResult.get(0).getCount(),Long.valueOf(2));
        Assert.assertEquals(votingResult.get(1).getId(),Integer.valueOf(100004));
        Assert.assertEquals(votingResult.get(1).getCount(),Long.valueOf(1));
    }

    @Test
    public void deleteVotes() throws Exception {
        votingService.deleteVotes();
        VOTE_MATCHER.assertCollectionEquals(Arrays.asList(),votingService.getAllVotes());
    }

    @Test
    public void getAllVotes() throws Exception {
        VOTE_MATCHER.assertCollectionEquals(Arrays.asList(VOTE1, VOTE2, VOTE3), votingService.getAllVotes());
    }

}