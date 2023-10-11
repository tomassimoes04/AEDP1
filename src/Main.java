import java.util.Scanner;

public class Main {
    private static final String ADDUSER = "ADDUSER";
    private static final String ADDARTIST = "ADDARTIST";
    private static final String REMOVEUSER = "REMOVEUSER";
    private static final String ADDWORK = "ADDWORK";
    private static final String INFOUSER = "INFOUSER ";
    private static final String INFOARTIST = "INFOARTIST";
    private static final String INFOWORK = "INFOWORK";
    private static final String CREATEAUCTION = "CREATEAUCTION";
    private static final String ADDWORKAUCTION = "ADDWORKAUCTION";
    private static final String BID = "BID";
    private static final String CLOSEAUCTION = "CLOSEAUCTION";
    private static final String LISTAUCTIONWORKS = "LISTAUCTIONWORKS";
    private static final String LISTBIDSWORK = "LISTBIDSWORK";
    private static final String QUIT = "QUIT";

    public static void main(String[] args) {

        Main.commands();

    }

    private static void commands() {
        App app = new AppClass();
        Scanner in = new Scanner(java.lang.System.in);
        String command;
        do {
            command = in.next().toUpperCase();
            switch (command) {
                case QUIT -> java.lang.System.out.println("Obrigado. Ate a proxima.");
                case ADDUSER -> commandAddUser(app, in);
                case ADDWORK -> commandAddWork(app, in);
                case ADDARTIST -> commandAddArtist(app, in);
                case REMOVEUSER -> commandRemoveUser(app, in);
                case INFOUSER -> commandInfoUser(app, in);
                case INFOWORK -> commandInfoWork(app, in);
                case INFOARTIST -> commandInfoArtist(app, in);
                case CREATEAUCTION -> commandCreateAuction(app, in);
                case ADDWORKAUCTION -> commandAddWorkAuction(app, in);
                case BID -> commandBid(app, in);
                case CLOSEAUCTION -> commandCloseAuction(app, in);
                case LISTAUCTIONWORKS -> commandListAuctionWork(app, in);
                case LISTBIDSWORK -> commandListBidsWork(app, in);

                default -> java.lang.System.out.println("Unknown command. Type help to see available commands.");
            }
        } while (!command.equals(QUIT));
        in.close();
    }

    private static void commandAddUser(App app, Scanner in){

    }

    private static void commandAddArtist(App app, Scanner in){

    }

    private static void commandRemoveUser(App app, Scanner in){

    }

    private static void commandAddWork(App app, Scanner in){

    }

    private static void commandInfoUser(App app, Scanner in){

    }

    private static void commandInfoArtist(App app, Scanner in){

    }

    private static void commandInfoWork(App app, Scanner in){

    }

    private static void commandCreateAuction(App app, Scanner in){

    }

    private static void commandAddWorkAuction(App app, Scanner in){

    }

    private static void commandBid(App app, Scanner in){

    }

    private static void commandCloseAuction(App app, Scanner in){

    }

    private static void commandListAuctionWork(App app, Scanner in){

    }

    private static void commandListBidsWork(App app, Scanner in){

    }

}