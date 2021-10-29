package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] artikli = new Artikl[1000];
    private int velicina = 0;

    public void dodajArtikl(Artikl artikl) {
        artikli[velicina] = artikl;
        velicina = velicina + 1;
    }

    public Artikl[] getArtikli() { return artikli; }
    public Artikl izbaciArtiklSaKodom(String kod) {
        for(int i = 0; i < velicina; i++) {
            int pomocni = Integer.parseInt(artikli[i].getKod());
            if ( pomocni == Integer.parseInt(kod)) {
                Artikl vrati = artikli[i];
                System.arraycopy(artikli, i+1, artikli, i, velicina - 1);
                velicina = velicina - 1;
                return vrati;
            }
        }
        return null;
    }
    public int getVel() { return velicina; }
}
