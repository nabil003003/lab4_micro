package test;

import entities.Machine;
import entities.Salle;
import services.MachineService;
import services.SalleService;

public class MainTest {
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();
        Salle salleInformatique = new Salle("S1", "Salle Informatique");

        if (!salleService.create(salleInformatique)) throw new IllegalStateException("La création de la salle a échoué");
        Machine machineDell = new Machine("M-101", "Dell", salleInformatique);
        if (!machineService.create(machineDell)) throw new IllegalStateException("La création de la machine a échoué");
        System.out.println("Données insérées avec succès !");
    }
}
