package code.refactoring._01_smell_mysterious_name._04_rename_field;

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
     * 필드 이름 바꾸기
     */

    //TODO : usernames -> reviewers 변경 Description : review 에 작성자들을 읽는데 usernames 보다 reviewers 가 더 적절.

    //TODO : 자바 14부터 record 라는 자료구조가 생김. 그 전에는 dto, vo 형태로 final, setter 제한 등으로 immutable 하게 작업 했었음.
//    private Set<String> reviewers = new HashSet<>();
//    private Set<String> reviews = new HashSet<>();
    private Set<StudyReview> studyReviews = new HashSet<>();


    /**
     * 이슈에 작성되어 있는 이슈 작성자 목록과 코멘트 작성자 목록을 읽어옵니다.
     * @throws IOException
     */
    private void loadReviews() throws IOException {
        GitHub gitHub = new GitHubBuilder().withOAuthToken("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").build();
        GHRepository repository = gitHub.getRepository("tmome/code-refactoring");
        GHIssue issue = repository.getIssue(30);

        List<GHIssueComment> reviews = issue.getComments();
        for (GHIssueComment review : reviews) {
            studyReviews.add(new StudyReview(review.getUserName(), review.getBody()));
        }
    }

    public Set<StudyReview> getStudyReviews() {
        return studyReviews;
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.loadReviews();
        studyDashboard.getStudyReviews().forEach(System.out::println);
    }
}
