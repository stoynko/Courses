package Exam_Preparations.ExamPrep_01.E01_MushroomPicking.entities.pickers;

import Exam_Preparations.ExamPrep_01.E01_MushroomPicking.entities.bag.Bag;

public interface Picker {
    String getName();
    int getVitality();
    Bag getBag();
    void pick();
}
