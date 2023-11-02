package System;


import java.io.Serializable;

public interface Bid extends Serializable {
    /**
     * Get the login of the buyer who placed the bid.
     * @return The login of the buyer.
     */
    String getBuyerLogin();

    /**
     * Get the name of the buyer who placed the bid.
     * @return The name of the buyer.
     */
    String getBuyerName();

    /**
     * Get the value of the bid.
     * @return The bid value.
     */
    int getValue();

    /**
     * Get the ID of the auction associated with the bid.
     * @return The auction ID.
     */
    String getAuctionId();

    /**
     * Get the user who placed the bid.
     * @return The User object representing the buyer.
     */
    User getUser();



}
