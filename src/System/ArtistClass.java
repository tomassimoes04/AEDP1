package System;


import dataStructures.*;
public class ArtistClass extends UserClass implements Artist{
    private String artisticname;
    private DoubleList<Work> works= new DoubleList<>();
    private int numofworks=0;
    public ArtistClass(int age, String name, String login, String email,String artisticname) {
        super(age, name, login, email);
        this.artisticname=artisticname;
    }

    @Override
    public String getArtisticName() {
        return artisticname;
    }


    protected void addWork(Work work) {
        works.add(numofworks,work);
        numofworks++;
    }


}
