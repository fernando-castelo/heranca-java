package entities;

public class PessoaFisica extends Pessoa {

    private Double gastosSaude;


    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }


    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double imposto(){
        if(getRendaAnual() < 20000){
            if(gastosSaude > 0){
                return (getRendaAnual() * 0.15) - (gastosSaude * 0.50);
            }
            else{
                return getRendaAnual() * (0.15);
            }
        }
       else{
            if(gastosSaude > 0){
                return (getRendaAnual() * 0.25) - (gastosSaude * 0.50);
            }
            else{
                return getRendaAnual() * 0.25;
            }
        }
    }
}
