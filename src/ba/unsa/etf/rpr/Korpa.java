package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli = new Artikl[50];
    private int velicina = 0;

    public boolean dodajArtikl(Artikl artikl) {
        if (velicina >= 50) return false;
        artikli[velicina] = artikl;
        velicina = velicina + 1;
        return true;
    }
    public Artikl[] getArtikli() { return artikli; }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for(int i = 0; i < velicina; i++) {
            if(kod.equals(artikli[i].getKod())) {
                Artikl vrati = artikli[i];
                artikli[i] = null;
                System.arraycopy(artikli, i+1, artikli, i, velicina-i);
                velicina = velicina - i;
                return vrati;
            }
        }
        return null;
    }
    public int dajUkupnuCijenuArtikala() {
        int ukupno = 0;
        for(int i = 0; i < velicina; i++) {
            ukupno = ukupno + artikli[i].getCijena();
        }
        return ukupno;
    }
    public int getVel() {return velicina; }
}
