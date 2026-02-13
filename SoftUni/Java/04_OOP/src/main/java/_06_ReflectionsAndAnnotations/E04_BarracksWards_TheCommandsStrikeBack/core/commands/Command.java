package _06_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands;

import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Executable;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Repository;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
