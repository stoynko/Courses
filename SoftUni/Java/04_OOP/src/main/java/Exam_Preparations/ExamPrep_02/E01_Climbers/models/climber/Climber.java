package Exam_Preparations.ExamPrep_02.E01_Climbers.models.climber;

import Exam_Preparations.ExamPrep_02.E01_Climbers.models.roster.Roster;

public interface Climber {
    String getName();
    double getStrength();
    boolean canClimb();
    Roster getRoster();
    void climb();
}
