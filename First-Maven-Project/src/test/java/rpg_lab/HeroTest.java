package rpg_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void hero_Gains_Experience_After_Attack_If_Target_Dies() {

        /*Target fakeTarget = new Target() {
            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return 10;
            }

            @Override
            public boolean isDead() {
                return true;
            }


        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };*/


        Weapon fakeWeapon = Mockito.mock(Weapon.class);
        Target fakeTarget = Mockito.mock(Target.class);

        Mockito.when(fakeTarget.isDead()).thenReturn(true);
        Mockito.when(fakeTarget.giveExperience()).thenReturn(10);

        Hero hero = new Hero("Roger", fakeWeapon);
        hero.attack(fakeTarget);
        Assertions.assertEquals(10,hero.getExperience(),"Wrong experience");
    }


}