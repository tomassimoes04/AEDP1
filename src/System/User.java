package System;

//interface userModify
import dataStructures.*;

import java.io.Serializable;

public interface User extends Serializable {

    /**
     * return the user's login
     * @return User's login
     */
    String getLogin();

    /**
     * return the user's name
     * @return User's name
     */
    String getName();

    /**
     * return the user's age
     * @return User's age
     */
    int getAge();

    /**
     * returns the user's email
     * @return User's email
     */
    String getEmail();

    /**
     * checks if the user has active bids
     * @return true if User has bids, false otherwise
     */
    boolean hasBids();
}
