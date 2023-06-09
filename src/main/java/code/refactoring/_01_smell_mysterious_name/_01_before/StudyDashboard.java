package code.refactoring._01_smell_mysterious_name._01_before;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public class StudyDashboard {

    /**
     * 이해하기 힘든 이름(냄세 나는 이해하기 힘든 이름 리펙토링)
     */

    private Set<String> usernames = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    private void studyReviews(GHIssue issue) throws IOException {
        List<GHIssueComment> comments = issue.getComments();
        for (GHIssueComment comment : comments) {
            usernames.add(comment.getUserName());
            reviews.add(comment.getBody());
        }
    }

    public Set<String> getUsernames() {
        return usernames;
    }

    public Set<String> getReviews() {
        return reviews;
    }

    public static void main(String[] args) throws IOException {
        GitHub gitHub = new GitHubBuilder().withOAuthToken("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").build();

        GHRepository repository = gitHub.getRepository("tmome/code-refactoring");
        GHIssue issue = repository.getIssue(1);

        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.studyReviews(issue);
        studyDashboard.getUsernames().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
