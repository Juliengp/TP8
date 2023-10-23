package champollion;

public class Salle {
    private String intitule;
    private int capacite;

    public Salle(String intitule, int capacite){
        this.intitule=intitule;
        this.capacite=capacite;
    }

    @Override
    public String toString(){
        return "Salle : " + intitule + " -- Capacité : " + capacite;
    }

    public int getCapacite(){
        return capacite;
    }

    public String getIntitule(){
        return intitule;
    }

    public void setCapacite(int nvCapacite){
        this.capacite=nvCapacite;
    }

    public void setIntitule(String nvIntitule){
        this.intitule=nvIntitule;
    }
    
}
