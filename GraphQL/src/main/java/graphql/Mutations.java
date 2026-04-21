package graphql;

import graphql.kickstart.tools.GraphQLMutationResolver;
import entities.UniteEnseignement;
import entities.Module;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

public class Mutations implements GraphQLMutationResolver {
    private ModuleBusiness mb;
    private UniteEnseignementBusiness ueb;
    public Mutations(ModuleBusiness mb, UniteEnseignementBusiness ueb) {
        this.mb = mb;
        this.ueb = ueb;
    }


    public boolean addModule(String matricule, String libelle, int coef, int volumeHoraire,
                             Module.TypeModule type, int codeUE) {
        UniteEnseignement ue =ueb.getUEByCode(codeUE);
        if (ue != null) {
            Module m = new Module(matricule, libelle, coef, volumeHoraire, type, ue);
            return mb.addModule(m);
        }
        return false;
    }

    public Module updateModule(String matricule, String libelle, int coef, int volumeHoraire,
                                Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = ueb.getUEByCode(codeUE);
        if (ue != null) {
            Module updated = new Module(matricule, libelle, coef, volumeHoraire, type, ue);
             if(mb.updateModule(matricule, updated))
                 return updated;


        } return null;

    }


    public String deleteModule(String matricule) {
         if(mb.deleteModule(matricule))
             return "deleted successfully";
         return "failed to delete module";
    }

    public boolean addUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueb.addUniteEnseignement(ue);
    }


    public boolean updateUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement updatedUE = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueb.updateUniteEnseignement(code, updatedUE);
    }


    public boolean deleteUniteEnseignement(int code) {
        return ueb.deleteUniteEnseignement(code);
    }
}
