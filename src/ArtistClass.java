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

    @Override
    public Iterator<Work> getWorks() {
        return works.iterator();
    }

    public int getNumofworks() {
        return numofworks;
    }

    @Override
    public void addWork(String workId, Artist artist, int year, String name) {
        works.add(numofworks,new WorkClass(workId, artist, year, name));
        numofworks++;
    }
    public String getFirstWork(String id){
        return works.getFirst().getId();
    }

    @Override
    public boolean hasWork(String workId) {
        for (int i = 0; i < numofworks; i++) {
            Work work1 = works.get(i);
            if (work1.getId().equals(workId)) {
                return true;
            }
        }
        return false;
    }
}
