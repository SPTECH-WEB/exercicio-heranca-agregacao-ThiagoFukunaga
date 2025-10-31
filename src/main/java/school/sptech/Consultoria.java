package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import  java.util.List;
import java.util.ArrayList;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.desenvolvedores = new ArrayList<>();
        this.nome = nome;
        this.vagas = vagas;
    }
    public Consultoria(){}

    public void contratar(Desenvolvedor desenvolvedor){
        if(vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
        }

    }


    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if( vagas >= desenvolvedores.size()  && desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
     Double totalSalario = 0.0;
     for(Desenvolvedor i : desenvolvedores){
     totalSalario += i.calcularSalario();
     }
     return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdM = 0;
        for (Desenvolvedor i : desenvolvedores){
            if(i instanceof DesenvolvedorMobile){
                qtdM ++;
            }
        }
        return qtdM;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> salarios = new ArrayList<>();
        for(Desenvolvedor i : desenvolvedores){
            if(i.calcularSalario() > salario){
                salarios.add(i);
            }
        }
        return salarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor MenorSalario = desenvolvedores.get(0);

        for(Desenvolvedor i : desenvolvedores){
            if(i.calcularSalario() < MenorSalario.calcularSalario()){
                MenorSalario = i;
            }
        }
        return MenorSalario;
    }


    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resultado = new ArrayList<>();

        for (Desenvolvedor i : desenvolvedores) {
            if (i instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb web = (DesenvolvedorWeb) i;
                if (tecnologia.equalsIgnoreCase(web.getFrontend()) ||
                        tecnologia.equalsIgnoreCase(web.getBackend()) ||
                        tecnologia.equalsIgnoreCase(web.getSgbd())) {
                    resultado.add(web);
                }
            } else if (i instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile mob = (DesenvolvedorMobile) i;
                if (tecnologia.equalsIgnoreCase(mob.getPlataforma()) ||
                        tecnologia.equalsIgnoreCase(mob.getLinguagem())) {
                    resultado.add(mob);
                }
            }
        }
        return resultado;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double total = 0.0;
        for (Desenvolvedor i : buscarPorTecnologia(tecnologia)) {
            total += i.calcularSalario();
        }
        return total;
    }



}
