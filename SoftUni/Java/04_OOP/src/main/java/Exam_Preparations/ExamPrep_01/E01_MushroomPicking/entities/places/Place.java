package Exam_Preparations.ExamPrep_01.E01_MushroomPicking.entities.places;

import Exam_Preparations.ExamPrep_01.E01_MushroomPicking.entities.pickers.Picker;

import java.util.Collection;

public interface Place {

    String getName();
    Collection<String> getMushrooms();
    Collection<Picker> getPickers();
}
