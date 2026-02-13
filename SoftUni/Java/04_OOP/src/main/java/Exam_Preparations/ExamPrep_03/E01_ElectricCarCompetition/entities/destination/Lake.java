package Exam_Preparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination;

public class Lake extends BaseDestination {

    public static final int DISTANCE_TO_REACH = 25;

    public Lake(String name) {
        super(name, DISTANCE_TO_REACH);
    }
}
