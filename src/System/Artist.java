package System;


import dataStructures.*;

import java.io.Serializable;

public interface Artist extends User, Serializable {

    String getArtisticName();
    Iterator<Work> getWorks();
    int getNumofworks();
    void addWork(String workId, Artist artist, int year, String name);
    boolean hasWork(String workId);
}
