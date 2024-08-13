package rpg_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rpg_lab.Axe.DURABILITY_LOST;

public class AxeTest {

    private static final Dummy DUMMY = new Dummy(13, 42);
    private static final int ATTACK = 10;
    private static final int DURABILITY = 50;
    private Axe axe;

    @Test
    public void test_AxeLoosesDurability_OnAttack() {

        Axe axe = new Axe(ATTACK, DURABILITY);

        axe.attack(DUMMY);

        int expected = DURABILITY - DURABILITY_LOST;
        int actual = axe.getDurabilityPoints();

        assertEquals(expected, actual,"Wrong durability:");
    }

    @Test
    public void test_AxeAttack_WhenBroken_ThrowsIllegalStateException() {
        Axe brokenAxe = new Axe(10, 0);

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> brokenAxe.attack(DUMMY));
        assertEquals("Axe is broken.", ex.getMessage());
    }




}
