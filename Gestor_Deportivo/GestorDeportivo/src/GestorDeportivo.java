import java.util.Scanner;

public class GestorDeportivo {
    public static void main(String[] args) {

        Matches matchList = new Matches();
        PlayerList playerList = new PlayerList();
        playerList.addPlayer("Luisa");
        playerList.addScore("Luisa", 4.5);
        playerList.addPlayer("Manuel");
        playerList.addScore("Manuel", 2.7);
        playerList.addPlayer("Kurt");
        playerList.addScore("Kurt", 4.0);
        playerList.addPlayer("Sofia");
        playerList.addScore("Sofia", 3.8);
        playerList.addPlayer("Robert");
        playerList.addScore("Robert", 3.8);

        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println();

        System.out.println("Ingrese uno de los siguientes comandos: añadir, eliminar, mostrar, añadir_puntuacion, score, mostrar_matchmaking, limpiar_matchmaking, matchmaking, random_matchmaking o exit");
        System.out.println("Jugadores actuales: ");
        playerList.show();
        System.out.println();
        do {
            command = scanner.nextLine().trim();

            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "añadir":
                    playerList.addPlayer(parts[1]);
                    break;
                case "eliminar":
                    playerList.remove(parts[1]);
                    break;
                case "mostrar":
                    playerList.show();
                    break;
                case "ranking":
                    playerList.rank();
                    break;
                case "añadir_puntuacion":
                    String[] scoreParts = parts[1].split(",");
                    playerList.addScore(scoreParts[0], Double.parseDouble(scoreParts[1]));
                    break;
                case "mostrar_matchmaking":
                    matchList.showMatchmake();
                    break;
                case "limpiar_matchmaking":
                    matchList.clearMatch();
                    break;
                case "matchmaking":
                    String[] matchParts = parts[1].split(",");
                    Player player1 = playerList.getPlayerByName(matchParts[0]);
                    Player player2 = playerList.getPlayerByName(matchParts[1]);
                    matchList.matchmake(player1, player2);
                    break;
                case "random_matchmaking":
                    matchList.randomMatchmake(playerList);
                    break;
                case "exit":
                    System.out.println("Saliendo.");
                    break;
                default:
                    System.out.println("Comando no valido");
            }
        } while (!command.equals("exit"));
        scanner.close();
    }
}
