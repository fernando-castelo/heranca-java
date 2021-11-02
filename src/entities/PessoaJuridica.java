package entities;

public class PessoaJuridica extends Pessoa {

    private Integer numFuncionarios;

    public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
        super(nome, rendaAnual);
        this.numFuncionarios = numFuncionarios;
    }

    public Integer getNumFuncionarios() {
        return numFuncionarios;
    }


    @Override
    public Double imposto(){
        if(numFuncionarios <= 10){
        return getRendaAnual() * 0.16;
        }
        else {
            return getRendaAnual() * 0.14;
        }
    }


}