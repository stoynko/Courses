package _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;

import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.annotations.Inject;
import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Repository;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
