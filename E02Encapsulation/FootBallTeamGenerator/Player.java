package E02Encapsulation.FootBallTeamGenerator;

public class Player {
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public Player(String name,
                  double endurance,
                  double sprint,
                  double dribble,
                  double passing,
                  double shooting){
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    public double getEndurance() {
        return endurance;
    }

    public double getSprint() {
        return sprint;
    }

    public double getDribble() {
        return dribble;
    }

    public double getPassing() {
        return passing;
    }

    public double getShooting() {
        return shooting;
    }

    public double getAverageStats(){
        return (this.getDribble() + this.getEndurance() + this.getPassing() + this.getShooting() + this.getSprint()) / 5;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(double endurance) {
        if(endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100. ");
        }
        this.endurance = endurance;
    }

    private void setSprint(double sprint) {
        if(endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100. ");
        }
        this.sprint = sprint;
    }

    private void setDribble(double dribble) {
        if(endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100. ");
        }
        this.dribble = dribble;
    }

    private void setPassing(double passing) {
        if(endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Passing should be between 0 and 100. ");
        }
        this.passing = passing;
    }

    private void setShooting(double shooting) {
        if(endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("shooting should be between 0 and 100. ");
        }
        this.shooting = shooting;
    }


}
