package dto;

public class Grade {
	private int gradeId;
	private String gradeName;
	private Long gradeMinimum;
	private Long gradeMaximum;
	private int charge;
	
	public Grade() {}

	public Grade(int gradeId, String gradeName, Long gradeMinimum, Long gradeMaximum, int charge) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.gradeMinimum = gradeMinimum;
		this.gradeMaximum = gradeMaximum;
		this.charge = charge;
	}

	public int getGradeId() {
		return gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public Long getGradeMaximum() {
		return gradeMaximum;
	}

	public Long getGradeMinimum() {
		return gradeMinimum;
	}

	public int getCharge() {
		return charge;
	}
}
