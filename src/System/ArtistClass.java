package System;


import dataStructures.*;
public class ArtistClass extends UserClass implements Artist{
    String artisticname;
    DoubleList<Work> works= new DoubleList<>();
    int numofworks=0;
    public ArtistClass(int age, String name, String login, String email,String artisticname) {
        super(age, name, login, email);
        this.artisticname=artisticname;
    }

    @Override
    public String getArtisticName() {
        return artisticname;
    }


    public Iterator<Work> getWorks() {
        return works.iterator();
    }
    protected void addWork(Work work) {
        works.add(numofworks,work);
        numofworks++;
    }
    public String getFirstWork(String id){
        return works.getFirst().getId();
    }

}
