package L02Encapsulation.L02FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Team team = new Team("Minior");
        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] arguments = reader.readLine().split("\\s+");
            team.addPerson(new Person(arguments[0],
                    arguments[1],
                    Integer.parseInt(arguments[2]),
                    Double.parseDouble(arguments[3])));

        }
        System.out.println(team);
    }
}
