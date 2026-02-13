package Exam_Preparations.ExamPrep_06.E01_HarpoonDiving.models.diver;

import Exam_Preparations.ExamPrep_06.E01_HarpoonDiving.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();
    double getOxygen();
    boolean canDive();
    SeaCatch getSeaCatch();
    void shoot();
}
