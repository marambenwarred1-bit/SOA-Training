package graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import java.util.List;


public class Query implements GraphQLQueryResolver {
    private ModuleBusiness mb;
    private UniteEnseignementBusiness ueb;
    public Query(ModuleBusiness mb, UniteEnseignementBusiness ueb) {
        this.mb = mb;
        this.ueb = ueb;
    }

    public List<Module> getallmodules(){
      return   mb.getAllModules();
    }

    public Module getModuleByMatricule(String matricule) {
        return mb.getModuleByMatricule(matricule);
    }


    public List<Module> getModulesByType(Module.TypeModule type) {
        return mb.getModulesByType(type);
    }

    public List<UniteEnseignement> getAllUE() {
        return ueb.getListeUE();
    }


    public UniteEnseignement getUEByCode(int code) {
        return ueb.getUEByCode(code);
    }


    public List<UniteEnseignement> getUEByDomaine(String domaine) {
        return ueb.getUEByDomaine(domaine);
    }


    public List<UniteEnseignement> getUEBySemestre(int semestre) {
        return ueb.getUEBySemestre(semestre);
    }

}
