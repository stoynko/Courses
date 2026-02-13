package _06_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands;

import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Repository;
import _06_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.UnitFactory;

public class FightCommand extends Command {

    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
