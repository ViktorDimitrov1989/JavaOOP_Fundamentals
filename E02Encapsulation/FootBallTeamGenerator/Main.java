package E02Encapsulation.FootBallTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,FootBallTeam> teams = new LinkedHashMap<>();

        String line;
        while (!"END".equals(line = reader.readLine())){
            String[] tokens = line.split(";");
            String command = tokens[0];
            try{
                switch (command){
                    case "Team":
                        createTeam(teams,tokens[1]);
                        break;
                    case "Add":
                        addPlayer(teams,tokens);
                        break;
                    case "Remove":
                        removePlayer(teams,tokens);
                        break;
                        default:
                            showStats(teams, tokens);
                            break;
                }
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }


        }
    }

    private static void showStats(Map<String, FootBallTeam> teams, String[] tokens) {
        String teamName = tokens[1];
        if(!teams.containsKey(teamName)){
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
        double rating = teams.get(teamName).getRating();
        System.out.println(String.format(teamName + " - %.0f", rating));
    }

    private static void removePlayer(Map<String, FootBallTeam> teams, String[] tokens) {
        String teamName = tokens[1];
        String playerToRemove = tokens[2];
        if(!teams.get(teamName).containsPlayer(playerToRemove)){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerToRemove, teamName));
        }
        teams.get(teamName).removePlayer(playerToRemove);
    }

    private static void addPlayer(Map<String, FootBallTeam> teams, String[] tokens) {
        String teamName = tokens[1];
        String playerName = tokens[2];
        double endurance = Double.parseDouble(tokens[3]);
        double sprint = Double.parseDouble(tokens[4]);
        double dribble = Double.parseDouble(tokens[5]);
        double passing = Double.parseDouble(tokens[6]);
        double shooting = Double.parseDouble(tokens[7]);

        Player player = new Player(playerName,
                endurance,
                sprint,
                dribble,
                passing,
                shooting);

        if(!teams.containsKey(teamName)){
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
        teams.get(teamName).addPlayer(player);

    }

    private static void createTeam(Map<String, FootBallTeam> teams, String teamName) {
        teams.put(teamName, new FootBallTeam(teamName));
    }
}
