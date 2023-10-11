import java.util.Scanner;

public class Main {
    private static String ADDUSER ="addUser";
    private static String ADDARTIST ="addArtist";
    private static String REMOVEUSER ="removeUser";
    private static String ADDWORK ="addWork";
    private static String INFOUSER = "infoUser ";
    private static String INFOARTIST ="infoArtist";
    private static String INFOWORK ="infoWork";
    private static String CREATEAUCTION ="createAuction";
    private static String ADDWORKAUCTION ="addWorkAuction";
    private static String BID = "bid";
    private static String CLOSEAUCTION ="closeAuction";
    private static String LISTAUCTIONWORKS="listAuctionWorks";
    private static String   LISTWORKSBYVALUE ="listBidsWork";
    private static String QUIT ="quit";

    public static void main(String[] args) {

        private static void commands() {
            App app = new AppClass();
            Scanner in = new Scanner(java.lang.System.in);
            String command;
            do {
                command = in.next().toUpperCase();
                switch (command) {
                    case QUIT -> java.lang.System.out.println("Obrigado. Ate a proxima.");
                    case ADDUSER ->
                    case ADDWORK ->
                    case ADDARTIST ->
                    case REMOVEUSER -> 
                    case INFOUSER ->
                    case INFOWORK ->
                    case INFOARTIST ->
                    case CREATEAUCTION ->
                    case ADDWORKAUCTION ->
                    case BID ->
                    case CLOSEAUCTION ->
                    case LISTAUCTIONWORKS ->
                    case LISTWORKSBYVALUE ->

                    default -> java.lang.System.out.println("Unknown command. Type help to see available commands.");
                }
            } while (!command.equals(QUIT));
            in.close();
        }
    }
}