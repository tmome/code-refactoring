package code.refactoring._02_duplicated_code._04_extract_function;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class StudyDashboard {
    //TODO : 의도와 구현을 명확히 분리할 것. 의도를 잘 들어 낼 것.

    private void printParticipants(int eventId) throws IOException {
        GHIssue issue = getGhIssue(eventId);
        Set<String> participants = getUsernames(issue);
        print(participants);
    }

    private static void print(Set<String> participants) {
        participants.forEach(System.out::println);
    }

    private static Set<String> getUsernames(GHIssue issue) throws IOException {
        Set<String> usernames = new HashSet<>();
        issue.getComments().forEach(c -> usernames.add(c.getUserName()));
        return usernames;
    }

    //TODO : 동일하게 중복 되는 코드를 의도를 들어나도록 리펙토링.
    private static GHIssue getGhIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("tmome/code-refactoring");
        GHIssue issue = repository.getIssue(eventId);
        return issue;
    }

    private void printReviewers() throws IOException {
        GHIssue issue = getGhIssue(30);
        Set<String> reviewers = getUsernames(issue);
        print(reviewers);
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }
}
