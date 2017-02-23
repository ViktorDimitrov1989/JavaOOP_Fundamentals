package E01DefiningClasses.E01FamilyTree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FamilyTree familyTree = new FamilyTree();
        String line = reader.readLine();

        Person personOfInterest = new Person();
        if(isValidDate(line)){
            personOfInterest.setBirthDate(line);
        }
        else{
            personOfInterest.setName(line);
        }
        familyTree.setPersonOfInterest(personOfInterest);

        while (!"End".equals(line = reader.readLine())){
            if(line.contains(" - ")){
                String[] arguments = line.split(" - ");
                String argument1 = arguments[0];
                String argument2 = arguments[1];

                Person parent = new Person();
                Person child = new Person();

                if(isValidDate(argument1)){
                    parent.setBirthDate(argument1);
                }
                else{
                    parent.setName(argument1);
                }
                if(isValidDate(argument2)){
                    child.setBirthDate(argument2);
                }
                else{
                    child.setName(argument2);
                }
                familyTree.getChildren().add(child);
                familyTree.getParents().add(parent);
                continue;
            }
            String[] arguments = line.split("\\s+");

            String name = arguments[0] + " " + arguments[1];
            String birthDate = arguments[2];

            //Person of interest
            if(personOfInterest.getName().equals(name)){
                familyTree.getPersonOfInterest().setBirthDate(birthDate);
            }
            else if(personOfInterest.getBirthDate().equals(birthDate)){
                familyTree.getPersonOfInterest().setName(name);
            }

            if(familyTree.getParents().stream().anyMatch(o -> o.getName().equals(name))
                    && familyTree.getParents().stream().noneMatch(o -> o.getBirthDate().equals(birthDate))){
                familyTree.findParentByBirthDate(name, birthDate);
            }
            if(familyTree.getParents().stream().anyMatch(o -> o.getBirthDate().equals(birthDate))
                    && familyTree.getParents().stream().noneMatch(o -> o.getName().equals(name))){
                familyTree.findParentByName(birthDate,name);
            }

            if(familyTree.getChildren().stream().anyMatch(o -> o.getName().equals(name))
                    && familyTree.getChildren().stream().noneMatch(o -> o.getName().equals(birthDate))){
                familyTree.findChildByName(name,birthDate);
            }
            if(familyTree.getChildren().stream().anyMatch(o -> o.getName().equals(birthDate))
                    && familyTree.getChildren().stream().noneMatch(o -> o.getName().equals(name))){
                familyTree.findChildByBirthDate(birthDate,name);
            }
        }

        System.out.println(familyTree);

    }

    private static boolean isValidDate(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        try {
            df.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
