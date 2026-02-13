package _06_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands;

import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Repository;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.UnitFactory;

public class RetireCommand extends Command {

    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            getRepository().removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
