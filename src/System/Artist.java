package System;


import dataStructures.*;

import java.io.Serializable;

public interface Artist extends User, Serializable {

    /**
     * returns the artist's artistic name
     * @return Artist's artistic name
     */
    String getArtisticName();


}
