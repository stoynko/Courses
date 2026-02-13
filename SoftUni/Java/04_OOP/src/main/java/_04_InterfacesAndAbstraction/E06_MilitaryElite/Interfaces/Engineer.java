package _04_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces;

import _04_InterfacesAndAbstraction.E06_MilitaryElite.Implementations.RepairImpl;

import java.util.Collection;

public interface Engineer {
    void addRepair(RepairImpl repair);
    Collection<RepairImpl> getRepairs();
}
