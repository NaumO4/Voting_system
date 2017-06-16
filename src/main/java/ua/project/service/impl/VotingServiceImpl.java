package ua.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ua.project.model.Restaurant;
import ua.project.model.Vote;
import ua.project.model.VoteCount;
import ua.project.repository.VoteRepository;
import ua.project.service.VotingService;

import java.util.List;

/**
 * Created by naum_ on 15-Jun-17.
 */
@Service
@Transactional(readOnly = true)
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VoteRepository repository;

    @Override
    @Transactional
    public void save(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        repository.save(vote);
    }

    @Override
    public Vote getUserVote(int userId) {
        return repository.findOne(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VoteCount> getVotingResult() {
        return repository.getCountVotes();
    }

    @Override
    @Transactional
    public void deleteVotes() {
        repository.deleteAll();
    }

    @Override
    public List<Vote> getAllVotes() {
        return repository.findAll();
    }
}
