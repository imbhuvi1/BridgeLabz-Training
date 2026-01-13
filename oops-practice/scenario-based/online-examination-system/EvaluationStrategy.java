package scenario_based.OnlineExaminationSystem;

import java.util.*;
// Evaluation abstraction
public interface EvaluationStrategy {

    int evaluate(List<Question> questions, List<String> answers);
}
