package edu.pdx.cs410J.ATeamName;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CharacterTest {

    @Test
    void characterObjectCanBeInstantiated() {
        Character character = new Character();
        assertThat(character.maxHealth, equalTo(1000));
        assertThat(character.isAlive, equalTo(true));
        assertThat(character.currentHealth, equalTo(1000));
        assertThat(character.level, equalTo(1));
    }

    @Test
    void dealingDamageTest(){
        Character character1 = new Character();
        Character character2 = new Character();
        character1.dealDamage(character2, 50);
        assertThat(character2.currentHealth, equalTo(950));
        assertThat(character1.currentHealth, equalTo(1000));
    }

    @Test
    void canKillCharacter(){
        Character character1 = new Character();
        Character character2 = new Character();
        character1.dealDamage(character2, 1001);
        assertThat(character2.currentHealth, equalTo(0));
        assertThat(character2.isAlive, equalTo(false));

    }

    @Test
    void cannotDamageSelf(){
        Character character1 = new Character();
        character1.dealDamage(character1, 75);
        assertThat(character1.currentHealth, equalTo(1000));
        assertThat(character1.isAlive, equalTo(true));
    }

    @Test
    void characterCanHeal(){
        Character character1 = new Character();
        Character character2 = new Character();
        character1.dealDamage(character2, 60);
        character2.heal();
        assertThat(character2.currentHealth, equalTo(character2.maxHealth));
    }

    @Test
    void deadCantHeal(){
        Character character1 = new Character();
        Character character2 = new Character();
        character1.dealDamage(character2, 1003);
        assertThat(character2.isAlive, equalTo(false));
        character2.heal();
        assertThat(character2.isAlive, equalTo(false));
        assertThat(character2.currentHealth, equalTo(0));
    }

    @Test
    void levelUpTest(){
        Character character1 = new Character();
        character1.levelUp();
        assertThat(character1.level, equalTo(2));
    }


}
