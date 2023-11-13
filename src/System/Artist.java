package System;
/**
 ˚ @author Tomás Martinho Simões (66152) tma.simoes@campus.fct.unl.pt
 ˚ @author Lourenço Calhau (65524) l.calhau@campus.fct.unl.pt
 */


import dataStructures.*;

import java.io.Serializable;

public interface Artist extends User, Serializable {

    /**
     * returns the artist's artistic name
     * @return Artist's artistic name
     */
    String getArtisticName();


}
