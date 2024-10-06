import java.util.Objects;

public class PlayerList {
    private Player[] list;
    private int Maxcapacity;
    private int capacity;

    public PlayerList(){
        this.Maxcapacity = 5;
        this.capacity = 0;
        this.list = new Player[Maxcapacity];
    }
    public int getCapacity(){
        return this.capacity;
    }
    public Player getPlayer(int player){
        return this.list[player];
    }
    public Player getPlayerByName(String player){
        int i = 0;
        while(i<this.capacity && player != this.list[i].getName()) i++;

        if(i<this.capacity){
            return list[i];
        }else return null;
    }
    private void extendList(){
        this.Maxcapacity *= 2;
        Player[] auxList = new Player[this.Maxcapacity];
        for (int i = 0; i < this.capacity; i++) {
            auxList[i] = this.list[i];
        }
        this.list = auxList;
    }
    private int getPosition(String name){
        int i = 0;
        while (i < this.capacity && !Objects.equals(name, this.list[i].getName())) {
            i++;
        }
        return i;
    }
    public void addPlayer(String name) {
        if (this.getPosition(name)!=this.capacity && this.capacity!=0) {
            System.out.println("El jugador " + name + " ya existe");
        } else {
                if (this.capacity == this.Maxcapacity){
                    this.extendList();
                }
                this.list[this.capacity] = new Player(name);
                this.capacity++;
        }
    }
    public void remove(String name){
        int position = this.getPosition(name);
        if (position == this.capacity || this.capacity == 0){
            System.out.println("No se ha encontrado el jugador " + name);
        }else{
            this.capacity--;
            while(position < this.capacity) {
                this.list[position] = this.list[position+1];
                position++;
            }
        }
    }
    public void show(){
        for (int i = 0; i < this.capacity; i++) {
            System.out.printf(this.list[i].getName() + "," + this.list[i].getScore());
            System.out.println();
        }
    }
    public void addScore(String name, double score) {
        if (score >= -999999.0) {
            if (this.getPosition(name) == this.capacity) {
                System.out.println("El jugador " + name + " no existe");
            } else {
                if (this.capacity == this.Maxcapacity) {
                    this.extendList();
                }
                this.list[this.getPosition(name)].setScore(score);
            }
        }else System.out.println("Puntuacion inferior al minimo");
    }
    public void rank(){
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity - i-1 ; j++) {
                if(list[j].getScore()<list[j+1].getScore()){
                    Player swap = list[j];
                    list[j] = list[j+1];
                    list[j+1] = swap;
                }
            }
        }
        for (int i = 0; i < capacity; i++) {
            System.out.println(list[i].getName() + ", " + list[i].getScore());
        }
    }

}
