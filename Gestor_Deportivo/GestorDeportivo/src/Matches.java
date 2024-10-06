import java.util.Random;
public class Matches {
    private Player[][] matches;
    private int Maxcapacity;
    private int capacity;

    public Matches(){
        this.Maxcapacity = 5;
        this.capacity = 0;
        this.matches = new Player[Maxcapacity][2];
    }
    private void extendList(){
        this.Maxcapacity *= 2;
        Player[][] auxList = new Player[this.Maxcapacity][2];
        for (int i = 0; i < this.capacity; i++) {
            for (int j = 0; j < 2; j++) {
                auxList[i][j] = this.matches[i][j];
            }

        }
        this.matches = auxList;
    }
    public void matchmake(Player player1, Player player2){
        if(this.capacity == this.Maxcapacity){
            this.extendList();
        }
        this.matches[this.capacity][0] = player1;
        this.matches[this.capacity][1] = player2;
        this.capacity++;
    }

    public void showMatchmake(){
        if(this.capacity == 0){
            System.out.println("No hay emparejamientos");
        }else{
            for (int i = 0; i < this.capacity-1; i++) {
                System.out.println(this.matches[i][0].getName() + "  vs  " + this.matches[i][1].getName());
            }
        }
    }

    public void randomMatchmake(PlayerList playerList){
        PlayerList auxList = playerList;
        if(auxList.getCapacity()%2 == 0){
            this.clearMatch();
            for (; this.capacity < auxList.getCapacity();) {
                if(this.capacity == this.Maxcapacity){
                    this.extendList();
                }
                Random random = new Random();
                int j = random.nextInt(auxList.getCapacity());
                Player aux = auxList.getPlayer(j);
                this.matches[this.capacity][0] = aux;
                auxList.remove(aux.getName());

                int j2 = random.nextInt(auxList.getCapacity());
                Player aux2 = auxList.getPlayer(j2);
                this.matches[this.capacity][1] = aux2;
                auxList.remove(aux2.getName());

                this.capacity++;
            }
        }else System.out.println("No se pudo emparejar");
    }
    public void clearMatch(){
        Matches aux = new Matches();
        this.matches = aux.matches;
        this.capacity = 0;
        this.Maxcapacity = 5;
    }
}
