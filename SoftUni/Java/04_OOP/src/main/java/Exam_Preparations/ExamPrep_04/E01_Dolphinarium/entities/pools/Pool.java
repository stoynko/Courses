package Exam_Preparations.ExamPrep_04.E01_Dolphinarium.entities.pools;

import Exam_Preparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins.Dolphin;
import Exam_Preparations.ExamPrep_04.E01_Dolphinarium.entities.foods.Food;

import java.util.Collection;

public interface Pool {
    String getName();

    int getCapacity();

    Collection<Dolphin> getDolphins();

    Collection<Food> getFoods();

    void addDolphin(Dolphin dolphin);

    void removeDolphin(Dolphin dolphin);

    void addFood(Food food);
}
