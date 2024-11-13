package studio8;

import java.util.Scanner;

public class Quiz {
	
    private Question[] questions;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    private String getUserAnswer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your answer: ");
        return in.next();
    }

    public int getTotalPoints() {
        int sum = 0;
        for (Question q : questions) {
            sum += q.getPoints();
        }
        return sum;
    }

    public void takeQuiz() {
        int totalEarned = 0;
        for (Question question : questions) {
            question.displayPrompt();
            String userAnswer = getUserAnswer();
            int earnedPoints = question.checkAnswer(userAnswer);
            System.out.println("You earned: " + earnedPoints + " points.");
            totalEarned += earnedPoints;
        }

        System.out.println("Quiz complete! Total points earned: " + totalEarned + "/" + getTotalPoints());
    }

    public static void main(String[] args) {
        Question q = new Question("What number studio is this?", "8", 2);

        String[] choices = {"seven", "nine", "eight", "six"};
        Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);

        choices = new String[] {"instance variables", "git", "methods", "eclipse"};
        Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);

        Question[] questions = {q, multipleChoice, selectAll};

        Quiz studio8quiz = new Quiz(questions);
        studio8quiz.takeQuiz();
    }
}
