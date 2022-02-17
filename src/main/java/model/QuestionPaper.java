package model;

public class QuestionPaper
{
	private int assessment;
	private String instructions;
	private int questionsCount;
	
	public int getAssessment() {
		return assessment;
	}
	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public int getQuestionsCount() {
		return questionsCount;
	}
	public void setQuestionsCount(int questionsCount) {
		this.questionsCount = questionsCount;
	}
}
