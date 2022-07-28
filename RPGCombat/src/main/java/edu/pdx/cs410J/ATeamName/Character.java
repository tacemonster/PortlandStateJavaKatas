package edu.pdx.cs410J.ATeamName;

public class Character {
    public Integer currentHealth;
    public Boolean isAlive;
    public Integer maxHealth;
    public Integer level;
    public Character() {
        currentHealth = 1000;
        maxHealth = 1000;
        isAlive = true;
        level = 1;
    }

    public void dealDamage(Character enemy, int damageAmount) {
        if (enemy.equals(this)) {
            return;
        }
        enemy.currentHealth -= damageAmount;
        if (enemy.currentHealth <= 0) {
            enemy.currentHealth = 0;
            enemy.isAlive = false;
        }
    }

    public void heal() {
        if (isAlive) {
            currentHealth = maxHealth;
        }
    }

    public void levelUp() {
    }
}
