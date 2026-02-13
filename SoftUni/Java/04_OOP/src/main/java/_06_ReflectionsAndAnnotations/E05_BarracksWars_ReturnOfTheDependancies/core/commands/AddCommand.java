package _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;


import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.annotations.Inject;
import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Repository;
import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Unit;
import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.UnitFactory;

public class AddCommand extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
