package Exam_Preparations.ExamPrep_05.E01_Restaurant.models.client;

import java.util.Collection;

public interface Client {

    Collection<String> getClientOrders();

    String getName();
}
