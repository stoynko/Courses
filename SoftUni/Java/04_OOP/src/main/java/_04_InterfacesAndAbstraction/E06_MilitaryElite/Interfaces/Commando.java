package _04_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces;

import _04_InterfacesAndAbstraction.E06_MilitaryElite.Implementations.MissionImpl;

import java.util.Collection;

public interface Commando {
    void addMission(MissionImpl mission);
    Collection<MissionImpl> getMissions();
}
