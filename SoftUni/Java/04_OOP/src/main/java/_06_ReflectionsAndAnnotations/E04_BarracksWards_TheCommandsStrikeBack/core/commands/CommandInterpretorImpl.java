package _06_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands;


import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.CommandInterpreter;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Executable;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.Repository;
import _06_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpretorImpl implements CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;
    public final static String COMMAND_PACKAGE = "src.D_OOP.G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.commands.";

    public CommandInterpretorImpl(Repository repository, UnitFactory unitFactory) {
        this.unitFactory = unitFactory;
        this.repository = repository;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = parseCommandToClassName(commandName);
        Executable command = null;
        try {
            Class commandClass = Class.forName(className);
            Constructor<Command> commandConstructor = commandClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            command = commandConstructor.newInstance(data, repository, unitFactory);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return command;
    }

    private String parseCommandToClassName (String commandName) {
        return COMMAND_PACKAGE + Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1) + "Command";
    }
}
