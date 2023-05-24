package code.refactoring._01_smell_mysterious_name._03_rename_variable;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class StudyDashboard {

    /**
     * 변수 이름 바꾸기
     */

    private Set<String> usernames = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    /**
     * 이슈에 작성되어 있는 이슈 작성자 목록과 코멘트 작성자 목록을 읽어옵니다.
     * @throws IOException
     */
    private void loadReviews() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("tmome/code-refactoring");
        GHIssue issue = repository.getIssue(1);

        //TODO : comments -> reviews 변경 Description : loadReviews 인데 문맥 상 comments 는 적절치 않음.
        List<GHIssueComment> reviews = issue.getComments();
        for (GHIssueComment review : reviews) {
            usernames.add(review.getUserName());
            this.reviews.add(review.getBody());
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

        //TODO : 타입 추론이 이미 가능한 경우 람다로 간결하게 표현 가능.
//        studyDashboard.getUsernames().forEach(name -> System.out.println(name));
        studyDashboard.getUsernames().forEach(System.out::println);
//        studyDashboard.getReviews().forEach(review -> System.out.println(review));
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
