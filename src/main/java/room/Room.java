package room;
import character.PlayableCharacter;
import treasure.Treasure;

import java.util.ArrayList;

public abstract class Room {

    private ArrayList<PlayableCharacter> roomPlayers;
    private ArrayList<Treasure> roomTreasures;
    private ArrayList<PlayableCharacter> roomEnemies;

    public Room() {
        this.roomPlayers = new ArrayList<>();
        this.roomTreasures = new ArrayList<>();
        this.roomEnemies = new ArrayList<>();
    }

    public void addPlayerToRoom(PlayableCharacter player){
            roomPlayers.add(player);
    }

    public void addTreasureToRoom(Treasure treasure){
            roomTreasures.add(treasure);
    }

    public void addEnemyToRoom(PlayableCharacter enemy){
        roomEnemies.add(enemy);
    }

    public ArrayList<PlayableCharacter> getRoomPlayers() {
        return roomPlayers;
    }

    public ArrayList<Treasure> getRoomTreasures() {
        return roomTreasures;
    }

    public ArrayList<PlayableCharacter> getRoomEnemies() {
        return roomEnemies;
    }

    public void removeTreasureFromRoom(Treasure treasure){
        this.roomTreasures.remove(treasure);
    }

    public void removeEnemyFromRoom(PlayableCharacter enemy) {
        this.roomEnemies.remove(enemy);
    }

    public void removePlayerFromRoom(PlayableCharacter player) {
        this.roomPlayers.remove(player);
    }

    public void attack(PlayableCharacter source, PlayableCharacter target) {
        target.lowerHealth(source.getWeapons().get(0).getDamage());
        source.lowerStamina(source.getWeapons().get(0).getStamina());
    }

    public void isEnemyDead(PlayableCharacter target){
        if(isCharacterDead(target)){
            removeEnemyFromRoom(target);
        }
    }

     public void isPlayerDead(PlayableCharacter target){
        if(isCharacterDead(target)) {
            removePlayerFromRoom(target);
         };
     }

    public Boolean isCharacterDead(PlayableCharacter character){
        Boolean isDead = false;
        if(character.getHealth() <= 0){
            isDead = true;
        }
        return isDead;
    }


}
