package Exam_Preparations.ExamPrep_02.E01_Climbers.models.climbing;

import Exam_Preparations.ExamPrep_02.E01_Climbers.models.climber.Climber;
import Exam_Preparations.ExamPrep_02.E01_Climbers.models.mountain.Mountain;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);
}
