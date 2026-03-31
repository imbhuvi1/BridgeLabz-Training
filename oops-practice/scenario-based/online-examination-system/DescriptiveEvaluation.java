package scenario_based.OnlineExaminationSystem;

import java.util.List;

// Descriptive evaluation logic
public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(List<Question> questions, List<String> answers) {
        return answers.size() * 2; // fixed marks per answer
    }
}