package Exam.E01_FishingFrenzy;

import Exam.E01_FishingFrenzy.core.Controller;
import Exam.E01_FishingFrenzy.core.ControllerImpl;
import Exam.E01_FishingFrenzy.core.Engine;
import Exam.E01_FishingFrenzy.core.EngineImpl;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}