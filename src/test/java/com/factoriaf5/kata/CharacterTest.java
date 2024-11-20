package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private Character character;

    @BeforeEach
    public void init(){
        this.character = new Character();

    }

    @Test
    public void dealDamageSimple() {
        int damage = 100;
        int onRange = 0;
        Character target = new Character();


        int result = character.dealDamage(target, damage, onRange);
        assertEquals(900, result);
    }

    @Test
    public void dealDamageOnRange5andIsRanged() {
        int damage = 100;
        int onRange = 5;
        Character character = new Character();
        Character target = new Character();
        target.health = 1000;
        character.isMelee = false;

        int result =  character.dealDamage(target, damage, onRange);

        assertEquals(900, result);
    }

    @Test
    public void dealDamageOnRange5andIsMelee() {
        int damage = 100;
        int onRange = 5;
        Character character = new Character();
        Character target = new Character();
        target.health = 1000;
        character.isMelee = true;

        int result =  character.dealDamage(target, damage, onRange);

        assertEquals(1000, result);
    }

    @Test
    public void dealDamageTargetIsDead() {
        int damage = 100;
        int onRange = 0;
        Character target = new Character();
        target.health = 0;

        int result = character.dealDamage(target, damage, onRange);

        assertEquals(0, result);
    }

    @Test
    public void dealDamageOnRange25() {
        int damage = 100;
        int OnRange = 25;
        Character character = new Character();
        Character target = new Character();
        target.health = 1000;
        character.isMelee = false;

        int result = character.dealDamage(target, damage, OnRange);

        assertEquals(1000, result);
    }

    @Test
    public void dealDamageOnRange25andIsMelee() {
        int damage = 100;
        int OnRange = 25;
        Character character = new Character();
        Character target = new Character();
        target.health = 1000;
        character.isMelee = true;

        int result = character.dealDamage(target, damage, OnRange);

        assertEquals(1000, result);
    }

    @Test
    public void dealDamageOnRange5lvlOver() {
        int damage = 100;
        int OnRange = 0;
        Character character = new Character();
        Character target = new Character();
        target.health = 1000;
        character.level = 6;
        target.level = 1;

        int result = character.dealDamage(target, damage, OnRange);
        assertEquals(850, result);
    }
    @Test
    public void dealDamageOnRange5lvlBehind() {
        int damage = 100;
        int OnRange = 0;
        Character character = new Character();
        Character target = new Character();
        target.health = 1000;
        character.level = 1;
        target.level = 6;

        int result = character.dealDamage(target, damage, OnRange);
        assertEquals(950, result);
    }

    @Test
    public void healingSimple() {
        Character character = new Character();
        int healingPoints = 100;
        character.health = 800;
        int result = character.healing(character, healingPoints);
        assertEquals(900, result);
    }

    @Test
    public void healingMax1000() {
        Character character = new Character();
        int healingPoints = 100;
        character.health = 999;
        int result = character.healing(character, healingPoints);
        assertEquals(1000, result);
    }
    






}


