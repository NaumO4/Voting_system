package ua.project;

import ua.project.matcher.ModelMatcher;
import ua.project.model.Vote;

import static ua.project.RestaurantTestData.RESTAURANT1;
import static ua.project.RestaurantTestData.RESTAURANT2;
import static ua.project.UserTestData.ADMIN_ID;
import static ua.project.UserTestData.USER2_ID;
import static ua.project.UserTestData.USER_ID;

/**
 * Created by naum_ on 16-Jun-17.
 */
public class VoteTestData {

    public static final Vote VOTE1 = new Vote(ADMIN_ID, RESTAURANT1);
    public static final Vote VOTE2 = new Vote(USER_ID, RESTAURANT1);
    public static final Vote VOTE3 = new Vote(USER2_ID, RESTAURANT2);

    public static final ModelMatcher<Vote> VOTE_MATCHER = new ModelMatcher<>();
}
