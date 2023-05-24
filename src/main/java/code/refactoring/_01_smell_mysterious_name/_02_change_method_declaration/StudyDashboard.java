package code.refactoring._01_smell_mysterious_name._02_change_method_declaration;

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
     * 함수 선언 변경하기
     */

    private Set<String> usernames = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    /**
     * 이슈에 작성되어 있는 이슈 작성자 목록과 코멘트 작성자 목록을 읽어옵니다.
     * @throws IOException
     */
    private void loadReviews() throws IOException {
        GitHub gitHub = new GitHubBuilder().withOAuthToken("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").build();
        GHRepository repository = gitHub.getRepository("tmome/code-refactoring");
        GHIssue issue = repository.getIssue(1);

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
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.loadReviews();
        studyDashboard.getUsernames().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
