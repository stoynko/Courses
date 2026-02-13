package _04_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;

import _04_InterfacesAndAbstraction.E06_MilitaryElite.Enums.Corp;
import _04_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corp corp;

    public SpecialisedSoldierImpl(String firstName, String lastName, int id, double salary, Corp corp) {
        super(firstName, lastName, id, salary);
        setCorp(corp);
    }

    public void setCorp(Corp corp) {
        this.corp = corp;
    }

    @Override
    public Corp getCorp() {
       return this.corp;
    }


}
