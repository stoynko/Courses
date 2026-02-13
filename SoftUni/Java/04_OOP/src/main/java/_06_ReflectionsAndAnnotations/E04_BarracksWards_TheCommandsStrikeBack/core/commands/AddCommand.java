package _06_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands;

import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Repository;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Unit;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.UnitFactory;

public class AddCommand extends Command {

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
