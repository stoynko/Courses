package Exam_Preparations.ExamPrep_03.E01_ElectricCarCompetition.entities.competition;

import Exam_Preparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car.Car;
import Exam_Preparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination.Destination;

import java.util.Collection;

public interface Competition {

    void startVoyage(Destination destination, Collection<Car> cars);
}
