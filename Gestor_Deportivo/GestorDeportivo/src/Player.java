public class Player {
    private String name;
    private  double score = 0.0;

    public Player(String name){
        this.name = name;
    }
    public void setScore(double score){
        if(score >= -999999.0) {
            this.score = score;
        }else System.out.println("No valido");
    }

    public String getName(){
        return this.name;
    }
    public double getScore(){
        return this.score;
    }
}
