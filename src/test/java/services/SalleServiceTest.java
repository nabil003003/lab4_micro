package services;

import entities.Salle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalleServiceTest {
    @Test
    public void testCreateSalle() {
        SalleService salleService = new SalleService();
        Salle salleReseau = new Salle("S2", "Salle Réseau");
        Assertions.assertTrue(salleService.create(salleReseau), "La création de la salle doit réussir");
    }
}
