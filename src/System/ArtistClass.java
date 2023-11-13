package System;
/**
 ˚ @author Tomás Martinho Simões (66152) tma.simoes@campus.fct.unl.pt
 ˚ @author Lourenço Calhau (65524) l.calhau@campus.fct.unl.pt
 */


import dataStructures.*;
public class ArtistClass extends UserClass implements Artist{
    static final long serialVersionUID = 1L;

    private final String artisticname;
    private DoubleList<Work> works;

    public ArtistClass(int age, String name, String login, String email,String artisticname) {
        super(age, name, login, email);
        this.artisticname=artisticname;
        works= new DoubleList<>();
    }

    @Override
    public String getArtisticName() {
        return artisticname;
    }

    /**
     * Add a work to the artist.
     * @param work - The work
     */
    protected void addWork(Work work) {
        works.addLast(work);

    }


}
