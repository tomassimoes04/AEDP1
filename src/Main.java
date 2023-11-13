import Exceptions.*;
import dataStructures.Iterator;
import System.*;

import java.io.*;
import java.util.Scanner;
/**
        ˚ @author Tomás Martinho Simões (66152) tma.simoes@campus.fct.unl.pt
        ˚ @author Lourenço Calhau (65524) l.calhau@campus.fct.unl.pt
        */
public class Main {
    private static final String ADDUSER = "ADDUSER";
    private static final String ADDARTIST = "ADDARTIST";
    private static final String REMOVEUSER = "REMOVEUSER";
    private static final String ADDWORK = "ADDWORK";
    private static final String INFOUSER = "INFOUSER";
    private static final String INFOARTIST = "INFOARTIST";
    private static final String INFOWORK = "INFOWORK";
    private static final String CREATEAUCTION = "CREATEAUCTION";
    private static final String ADDWORKAUCTION = "ADDWORKAUCTION";
    private static final String BID = "BID";
    private static final String CLOSEAUCTION = "CLOSEAUCTION";
    private static final String LISTAUCTIONWORKS = "LISTAUCTIONWORKS";
    private static final String LISTBIDSWORK = "LISTBIDSWORK";
    private static final String QUIT = "QUIT";
    private static final String LISTARTISTWORKS = "LISTARTISTWORKS";
    private static final String LISTWORKSBYVALUE = "LISTWORKSBYVALUE";

    public static void main(String[] args) throws NonExistingUser, AlredyExistingUser, NonExistingWork, WrongUserType, ExistingWork, InvalidAge, InsuficientBid, AlreadyExistingAuction, NonExistingAuction {
        App app = load();
        Main.commands(app);

    }

    /**
     * Process user commands and interact with the application.
     * @param app - The application instance to operate on.
     * @throws NonExistingUser - Thrown when a user does not exist.
     * @throws WrongUserType - Thrown when the user type is incorrect.
     * @throws ExistingWork - Thrown when a work already exists.
     * @throws AlredyExistingUser - Thrown when a user or artist already exists.
     * @throws NonExistingWork - Thrown when a work does not exist.
     * @throws InvalidAge - Thrown when the provided age is invalid.
     * @throws InsuficientBid - Thrown when the bid value is insufficient.
     * @throws NonExistingAuction - Thrown when an auction does not exist.
     * @throws AlreadyExistingAuction - Thrown when an auction already exists.
     */

    private static void commands(App app) throws NonExistingUser, WrongUserType, ExistingWork, AlredyExistingUser, NonExistingWork, InvalidAge, InsuficientBid, NonExistingAuction, AlreadyExistingAuction {
        Scanner in = new Scanner(java.lang.System.in);
        String command;
        do {
            command = in.next().toUpperCase();
            switch (command) {
                case QUIT -> java.lang.System.out.println("\nObrigado. Ate a proxima.");
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
                case LISTAUCTIONWORKS -> commandListAuctionWorks(app, in);
                case LISTBIDSWORK -> commandListBidsWork(app, in);

                default -> java.lang.System.out.println("Unknown command. Type help to see available commands.");
            }
            
        } while (!command.equals(QUIT));
        save(app);
        in.close();
    }

    @SuppressWarnings("unchecked")
    private static App load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sistema.txt"));
            App app = (AppClass) ois.readObject();
            ois.close();
            return app;
        } catch (IOException exception) {
            return new AppClass();
        } catch (ClassNotFoundException exception) {
            System.out.println("erro na serialization");
            return new AppClass();
        }
    }

    private static void save(App app) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream("sistema.txt")));
            oos.writeObject(app);
            oos.flush();
            oos.close();
        } catch (IOException exception) {
            System.out.println("problema a escrever");
        }
    }
    /**
     * Process the "ADDUSER" command to add a new user to the application.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandAddUser(App app, Scanner in) {
        String login = in.next();
        String name = in.nextLine().trim();
        int age = in.nextInt();
        String email = in.next();
        in.nextLine();
        try {
            app.addUser(login, name, age, email);
            System.out.println("\nRegisto de utilizador executado.\n");
        } catch (AlredyExistingUser | InvalidAge exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "ADDARTIST" command to add a new artist to the application.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandAddArtist(App app, Scanner in) {
        String login = in.next();
        String name = in.nextLine().trim();
        String artisticName = in.nextLine();
        int age = in.nextInt();
        String email = in.next();
        in.nextLine();
        try {
            app.addArtist(login, name, artisticName, age, email);
            System.out.println("\nRegisto de artista executado.\n");
        } catch (AlredyExistingUser | InvalidAge exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "REMOVEUSER" command to remove a user from the application.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandRemoveUser(App app, Scanner in) {
        String login = in.next();
        in.nextLine();
        try {
            app.removeUser(login);
            System.out.println("\nRemocao de utilizador executada.\n");
        } catch (NonExistingUser | BidsInAuction | WorksInAuction exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "ADDWORK" command to add a new work to the application.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */
    private static void commandAddWork(App app, Scanner in) {
        String workId = in.next();
        String login = in.next();
        int year = in.nextInt();
        String name = in.nextLine().trim();
        try {
            app.addWork(workId, login, year, name);
            System.out.println("\nRegisto de obra executado.\n");
        } catch (NonExistingUser | WrongUserType | ExistingWork exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "INFOUSER" command to retrieve information about a user and display it.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */
    private static void commandInfoUser(App app, Scanner in) {
        String login = in.next();
        in.nextLine();
        User user = app.getUser(login);
        if (user != null) {
            System.out.println("\n" + user.getLogin() + " " + user.getName() + " " + user.getAge() + " " + user.getEmail() + "\n");
        } else {
            System.out.println("\nUtilizador inexistente.\n");
        }
    }
    /**
     * Process the "INFOARTIST" command to retrieve information about a artist and display it.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandInfoArtist(App app, Scanner in) {
        String login = in.next();
        User user = app.getUser(login);
        if (user == null) {
            System.out.println("\nUtilizador inexistente.\n");
        } else if (!(user instanceof Artist)) {
            System.out.println("\nArtista inexistente.\n");
        } else {
            Artist artist = (Artist) app.getUser(login);
            System.out.println("\n" + artist.getLogin() + " " + artist.getName() + " " + artist.getArtisticName() + " " + artist.getAge() + " " + artist.getEmail() + "\n");
        }
    }
    /**
     * Process the "INFOWORK" command to retrieve information about a artist and display it.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandInfoWork(App app, Scanner in)  {
        String workId = in.next();
        in.nextLine();
        Work work = app.getWork(workId);
        if (work == null) {
            System.out.println("\nObra inexistente.\n");
        } else {
            System.out.println("\n" + work.getId() + " " + work.getName() + " " + work.getYear() + " " + work.getLastBuyValue() + " " + work.getArtistLogin() + " " + work.getArtistName() + "\n");
        }
    }
    /**
     * Process the "CREATEAUCTION" command to create a new auction.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandCreateAuction(App app, Scanner in)  {
        String auctionId = in.next();
        in.nextLine();
        try {
            app.createAuction(auctionId);
            System.out.println("\nRegisto de leilao executado.\n");
        } catch (AlreadyExistingAuction exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "ADDWORK" command to add a work to a auction.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandAddWorkAuction(App app, Scanner in)  {
        String auctionId = in.next();
        String workId = in.next();
        int minValue = in.nextInt();
        in.nextLine();
        try {
            app.addWorkAuction(auctionId, workId, minValue);
            System.out.println("\nObra adicionada ao leilao.\n");
        } catch (NonExistingWork | NonExistingAuction exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "ADDBID" command to add a bid to an auction.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandBid(App app, Scanner in)  {
        String auctionId = in.next();
        String workId = in.next();
        String login = in.next();
        int value = in.nextInt();
        in.nextLine();
        try {
            app.bid(auctionId, workId, login, value);
            System.out.println("\nProposta aceite.\n");
        } catch (NonExistingUser | InsuficientBid | NonExistingAuction | NonExistingWork exception) {
            System.out.println(exception.getMessage());
        }

    }
    /**
     * Process the "CLOSEAUCTION" command to close an auction and display the winners if they exist.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandCloseAuction(App app, Scanner in)  {
        String auctionId = in.next();
        in.nextLine();
        try {
            Iterator<WorkClass> it = app.closeAuction(auctionId);
            System.out.println("\nLeilao encerrado.");
            while (it.hasNext()) {
                Work work = it.next();
                if (work.wasSold()) {
                    System.out.println(work.getId() + " " + work.getName() + " " + work.getBuyerLogin() + " " + work.getBuyerName() + " " + work.getLastBuyValue());
                } else {
                    System.out.println(work.getId() + " " + work.getName() + " sem propostas de venda.");
                }
            }
            System.out.println();
        } catch (NonExistingAuction exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "LISTACUTIONWORKS" command to display the current works in an auction.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandListAuctionWorks(App app, Scanner in) {
        String auctionId = in.next();
        in.nextLine();
        try {
            Iterator<WorkClass> it = app.listAuctionWorks(auctionId);
            System.out.println();
            while (it.hasNext()) {
                Work work = it.next();
                System.out.println(work.getId() + " " + work.getName() + " " + work.getYear() + " " + work.highestBuyValue() + " " + work.getArtistLogin() + " " + work.getArtistName());
            }
            System.out.println();
        } catch (NonExistingAuction | NoWorks exception) {
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Process the "LISTBIDS" command to lists the bids made to a work in an auction.
     *
     * @param app - The application instance to operate on.
     * @param in - The Scanner for reading user input.
     */

    private static void commandListBidsWork(App app, Scanner in) {
        String auctionId = in.next();
        String workId = in.next();
        in.nextLine();
        try {
            Iterator<Bid> it = app.listBidsWork(auctionId, workId);
            System.out.println();
            while (it.hasNext()) {
                Bid bid = it.next();
                System.out.println(bid.getBuyerLogin() + " " + bid.getBuyerName() + " " + bid.getValue());
            }
            System.out.println();
        } catch (NonExistingAuction | NonExistingWork | NoBids exception) {
            System.out.println(exception.getMessage());
        }
    }
}