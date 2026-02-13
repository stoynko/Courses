package _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;

import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.annotations.Inject;
import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Repository;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            repository.removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
