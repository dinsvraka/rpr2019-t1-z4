package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] artikli = new Artikl[1000];
    private int velicina = 0;

    public boolean dodajArtikl(Artikl artikl) {
        if (velicina > 50) return false;
        artikli[velicina] = artikl;
        velicina++;
        return true;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for (int i = 0; i < velicina; i++) {
            if (kod.equals(artikli[i].getKod())) {
                Artikl izbaceni_artikl = artikli[i];
                artikli[i] = null;
                velicina--;
                System.arraycopy(artikli, i + 1, artikli, i, velicina);
                return izbaceni_artikl;
            }
        }
        return null;
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    public int dajUkupnuCijenuArtikala() {
        int cijena = 0;
        for (int i = 0; i < velicina; i++) cijena = cijena + artikli[i].getCijena();
        return cijena;
    }
}