package code.refactoring._03_long_function._12_split_loop._02_duplicated_code._06_pull_up_method;

import java.io.IOException;

public class Dashboard {

    public static void main(String[] args) throws IOException {
        ReviewerDashboard reviewerDashboard = new ReviewerDashboard();
        reviewerDashboard.printReviewers();

        ParticipantDashboard participantDashboard = new ParticipantDashboard();
        participantDashboard.printParticipants(15);
    }
}
