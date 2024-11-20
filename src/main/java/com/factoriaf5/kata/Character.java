package com.factoriaf5.kata;

public class Character {
    int health = 1000;
    int level = 1;
    int enemyLevel = 1;
    boolean isAlive = true;
    boolean isMelee;
   // int onRange = 0;



    public int dealDamage(Character target, int damage, int onRange) {
        if ((isMelee && onRange > 2) && (!isMelee && onRange > 20)){
            System.out.println("Target out of Range");
        }

        if (target != this && ((isMelee == true && onRange <= 2) || (isMelee == false && onRange <= 20))){
            if (target.level >= (level + 5)){
                damage = damage - (damage/2);
            } else if (target.level <= (level - 5)){
                damage = damage + (damage/2);
            }

            target.health = target.health - damage;

                if (target.health <= 0) {
                target.health = 0;
                target.isAlive = false;
                System.out.println("Dead!");
                }
        } else {
            System.out.println("You can't attack the target");
        }

        return target.health;
    }

    public int healing (Character character, int healingPoints){
        if (character == this) {
            if (isAlive = false) {
            System.out.println("Already dead!");
            } else {
                character.health = character.health + healingPoints;
            System.out.println("Healed!");
            }
        
            if (character.health > 1000) {
                character.health = 1000;
                System.out.println("You got the maximum of 1000 health");
            }
        } else {
            System.out.println("You can't heal someone else");
        }
        return character.health;
    }
}
