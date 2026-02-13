package Exam_Preparations.ExamPrep_09.E01_MagicGame.models.region;

import Exam_Preparations.ExamPrep_09.E01_MagicGame.models.magicians.Magician;

import java.util.Collection;

public interface Region {
    String start(Collection<Magician> magicians);
}
