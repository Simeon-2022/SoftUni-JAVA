package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class DummyTest {

    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 13;
    private static final int ATTACK_POINTS = 20;
    private static Dummy dummy; // = new Dummy(HEALTH, EXPERIENCE);
    private static Dummy deadDummy;

    @BeforeEach
    public void setUp() {
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0,EXPERIENCE);
    }

    @Test
    public void Dummy_Loses_Health_If_Attacked() {

        int expectedHealth = dummy.getHealth() - ATTACK_POINTS;
        dummy.takeAttack(ATTACK_POINTS);

        assertEquals(expectedHealth, dummy.getHealth());

    }

    @Test
    public void Alive_Dummy_Cant_Give_XP_ThrowsException() {

        IllegalStateException ex = assertThrows(IllegalStateException.class, dummy::giveExperience);

        assertEquals("Target is not dead.", ex.getMessage());
    }

    @Test
    public void Dead_Dummy_Throws_Exception_If_Attacked() {

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> deadDummy.takeAttack(ATTACK_POINTS));

        assertEquals("Dummy is dead.", ex.getMessage());
    }

    @Test
    public void Dead_Dummy_Gives_XP() {

        assertEquals(EXPERIENCE, deadDummy.giveExperience());
    }




}