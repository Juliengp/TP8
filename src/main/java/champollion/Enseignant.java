package champollion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Enseignant extends Personne {
    private final Set<Intervention> planning = new HashSet<>();
    private final Map<UE, ServicePrevu> enseignements = new HashMap<>();

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    public void ajouteIntervention(Intervention intervention){
        if(!enseignements.containsKey(intervention.getMatiere())){
            throw new IllegalArgumentException("Cette matiere n'existe pas");
        }
        planning.add(intervention);
    }

    public float equivalentTD(TypeIntervention type, int volumeHoraire){
        float result = 0f;
        switch (type){
            case CM : result = volumeHoraire*1.5f;break;
            case TD : result = volumeHoraire;break;
            case TP : result = volumeHoraire*0.75f;
        }
        return result;
    }

    public int heuresPlanif(){
        float result = 0f;
        for(Intervention intervention : planning){
            result = result + equivalentTD(intervention.getType(),intervention.getDuree());}
            return Math.round(result);
        }
    
        public boolean sousService(){
            return heuresPrevues()<192;
        }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        float result = 0f;
        for(UE ue : enseignements.keySet()){
            result += heuresPrevuesPourUE(ue);
        }
        return Math.round(result);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
       float result = 0f;
        ServicePrevu p = enseignements.get(ue);
        if (p!= null){
            result=equivalentTD(TypeIntervention.CM, p.getVolumeCM())+equivalentTD(TypeIntervention.TD, p.getVolumeTD()) + equivalentTD(TypeIntervention.TP, p.getVolumeTP());
        }
        return Math.round(result);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        if(volumeCM<0 || volumeTD<0 || volumeTP<0){
            throw new IllegalArgumentException("les volume horaires ne peuvent pas être négatifs");
        }

        ServicePrevu b = enseignements.get(ue);
        if(b==null){
            b = new ServicePrevu(volumeCM, volumeTD, volumeTP, ue);
            enseignements.put(ue,b);
        }
        else{
            b.setVolumeCM(volumeCM + b.getVolumeCM());
            b.setVolumeTD(volumeTD + b.getVolumeTD());
            b.setVolumeTP(volumeTP + b.getVolumeTP());
        }
    }


}
