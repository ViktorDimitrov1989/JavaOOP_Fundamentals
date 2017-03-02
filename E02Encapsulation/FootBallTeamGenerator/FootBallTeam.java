package E02Encapsulation.FootBallTeamGenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FootBallTeam {

    private List<Player> players;
    private String name;

    public FootBallTeam(String name) {
        this.setName(name);
        this.players = new LinkedList<>();
    }

    private List<Player> getPlayers(){
        return Collections.unmodifiableList(this.players);
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public boolean containsPlayer(String playerName){
        for (Player player : this.players) {
            if(player.getName().equals(playerName)){
                return true;
            }
        }
        return false;
    }

    public void removePlayer(String playerToRemove){
        for (Player player : this.players) {
            if(player.getName().equals(playerToRemove)){
                this.players.remove(player);
                return;
            }
        }
    }

    public double getRating(){
        double result = 0.0;
        for (Player player : this.players) {
            result += player.getAverageStats();
        }
        if(this.players.size() != 0){
            return result / this.players.size();
        }
        return 0;
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
}
