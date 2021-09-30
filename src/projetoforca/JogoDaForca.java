package projetoforca;


public class JogoDaForca {
    private Palavra[] dicionario;
    private String gabarito;
    private int posicaoSorteada;

    public String getGabarito() {
        return gabarito;
    }

    public int getPosicaoSorteada() {
        return posicaoSorteada;
    }

    public Palavra[] getDicionario() {
        return dicionario;
    }

    public void setDicionario(Palavra[] dicionario) {
        this.dicionario = dicionario;
    }
    
    public String pegarDica(){
        String pista;
        if(this.getPosicaoSorteada() < 5){
            pista = "Animal";
        }else if(this.getPosicaoSorteada() < 10){
            pista = "Fruta";
        }else if(this.getPosicaoSorteada() < 15){
            pista = "Veículo";
        }else{
            pista = "Roupa";
        }
        
        this.getDicionario()[this.getPosicaoSorteada()].setDica(pista);
        
        return this.getDicionario()[this.getPosicaoSorteada()].getDica();
    }
    
    public void sortear(){
        this.posicaoSorteada = (int)(Math.random() * this.getDicionario().length);
        this.gabarito = "";   
              
        while(this.getDicionario()[posicaoSorteada] == null){
            this.posicaoSorteada = (int)(Math.random() * this.getDicionario().length);
        }   
        
        for(int c = 0; c < this.getDicionario()[posicaoSorteada].getPalavra().length(); c++){
            this.gabarito += "?";
        }
    }
    
    public boolean testarLetra(char l){
        if(this.getDicionario()[posicaoSorteada].getPalavra().indexOf(l) != -1){
            char[] arrayR = this.getDicionario()[posicaoSorteada].getPalavra().toCharArray();
            char[] arrayG = this.gabarito.toCharArray();
            for(int c = 0; c < arrayR.length; c++){
                if(arrayR[c] == l){
                    arrayG[c] = l;
                }
            }
            this.gabarito = new String(arrayG);
            return true;
        }
        return false;
    }
    
    public boolean testaSeAcabou(){
        if(!this.getGabarito().contains("?")){
            this.getDicionario()[posicaoSorteada] = null;
            this.posicaoSorteada = -1;
            return true;
        }
        return false;
    }
    
}