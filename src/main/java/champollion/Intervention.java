package champollion;
import java.util.Date;

public class Intervention {
    private int duree;
    private Date date;
    private Enseignant intervenant;
    private UE matiere;
    private TypeIntervention type;
    private Salle lieu;

    public Intervention(int duree, Date date, Enseignant intervenant, UE matiere, TypeIntervention type, Salle lieu){
        this.duree=duree;
        this.date=date;
        this.intervenant=intervenant;
        this.matiere=matiere;
        this.type=type;
        this.lieu=lieu;}
    
    public int getDuree(){
        return duree;
    }

    public Date getDate(){
        return date;
    }

    public Enseignant getIntervenant(){
        return intervenant;
    }

    public UE getMatiere(){
        return matiere;
    }

    public TypeIntervention getType(){
        return type;
    }

    public Salle getLieu(){
        return lieu;
    }

    public void setDuree (int nvDuree){
        this.duree=nvDuree;
    }

    public void setDate (Date nvDate){
        this.date=nvDate;
    }

    public void setIntervenant(Enseignant nvIntervenant){
        this.intervenant=nvIntervenant;
    }

    public void setType(TypeIntervention nvType){
        this.type=nvType;
    }

    public void setLieu(Salle nvLieu){
        this.lieu=nvLieu;
    }

    }

