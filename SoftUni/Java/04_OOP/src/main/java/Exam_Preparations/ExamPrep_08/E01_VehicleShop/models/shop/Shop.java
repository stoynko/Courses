package Exam_Preparations.ExamPrep_08.E01_VehicleShop.models.shop;

import Exam_Preparations.ExamPrep_08.E01_VehicleShop.models.vehicle.Vehicle;
import Exam_Preparations.ExamPrep_08.E01_VehicleShop.models.worker.Worker;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}
