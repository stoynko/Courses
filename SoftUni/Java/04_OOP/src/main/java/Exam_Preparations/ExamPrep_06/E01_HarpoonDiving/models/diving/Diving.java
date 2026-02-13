package Exam_Preparations.ExamPrep_06.E01_HarpoonDiving.models.diving;

import Exam_Preparations.ExamPrep_06.E01_HarpoonDiving.models.diver.Diver;
import Exam_Preparations.ExamPrep_06.E01_HarpoonDiving.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {
    void searching(DivingSite divingSite, Collection<Diver> divers);
}
