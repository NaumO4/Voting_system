package ua.project.service;

import ua.project.model.Vote;
import ua.project.model.VoteCount;

import java.util.List;

/**
 * Created by naum_ on 14-Jun-17.
 */
public interface VotingService {

    void save(Vote vote);

    Vote getUserVote(int userId);

    List<VoteCount> getVotingResult();

    void deleteVotes();

    List<Vote> getAllVotes();
}
