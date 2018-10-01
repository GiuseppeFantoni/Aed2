import java.io.*;
import java.net.*;
import java.*;
import java.nio.charset.*;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;



class Series{

    //Atributos
   private String Nome;
   private String Formato;
   private String Duracao;
   private String PaisOrigem;
   private String IdiomaOriginal;
   private String EmissoraTv;
   private String TransOri;
   private int nTemp;
   private int nEp;

    //Construtores da classe Series;
   Series(){
      this.setNome("");
      this.setFormato("");
      this.setDuracao("");
      this.setPaisOrigem("");
      this.setIdiomaOriginal("");
      this.setEmissoraTv("");
      this.setTransOri("");
      this.setnTemp(0);
      this.setnEp(0);
   }

   Series(String Nome, String Formato, String Duracao, String PaisOrigem, String IdiomaOriginal, String EmissoraTv , String TransOri , int nTemp , int nEp){
      this.setNome(Nome);
      this.setFormato(Formato);
      this.setDuracao(Duracao);
      this.setPaisOrigem(PaisOrigem);
      this.setIdiomaOriginal(IdiomaOriginal);
      this.setEmissoraTv(EmissoraTv);
      this.setTransOri(TransOri);
      this.setnTemp(nTemp);
      this.setnEp(nEp);
   }

   //metodos set da class Series;
   public void setNome(String Nome){
      this.Nome = Nome;
   }

   public void setFormato(String Formato){
      this.Formato = Formato;
   }

   public void setDuracao(String Duracao){
      this.Duracao = Duracao;
   }

   public void setPaisOrigem(String PaisOrigem){
      this.PaisOrigem = PaisOrigem;
   }

   public void setIdiomaOriginal(String IdiomaOriginal){
      this.IdiomaOriginal = IdiomaOriginal;
   }

   public void setEmissoraTv(String EmissoraTv){
      this.EmissoraTv = EmissoraTv;
   }

   public void setTransOri(String TransOri){
      this.TransOri = TransOri;
   }

   public void setnTemp(int nTemp){
      this.nTemp = nTemp;
   }

   public void setnEp(int nEp){
      this.nEp = nEp;
   }

   //metodos get da class Series;
   public String getNome(){
      return this.Nome;
   }

   public String getFormato(){
      return this.Formato;
   }

   public String getDuracao(){
      return this.Duracao;
   }

   public String getPaisOrigem(){
      return this.PaisOrigem;
   }

   public String getIdiomaOriginal(){
      return this.IdiomaOriginal;
   }

   public String getEmissoraTv(){
      return this.EmissoraTv;
   }

   public String getTransOri(){
      return this.TransOri;
   }

   public int getnTemp(){
      return this.nTemp;
   }

   public int getnEp(){
      return this.nEp;
   }

   //Cria uma Serie que recebe os atributos do objeto corrente;
   public Series clone(){
      Series se = new Series();
      se.setNome(getNome());
      se.setFormato(getFormato());
      se.setDuracao(getDuracao());
      se.setPaisOrigem(getPaisOrigem());
      se.setIdiomaOriginal(getIdiomaOriginal());
      se.setEmissoraTv(getEmissoraTv());
      se.setTransOri(getTransOri());
      se.setnTemp(getnTemp());
      se.setnEp(getnEp());
   
      return se;
   }

//retorna os atributos da class Serie;
   public String toString() {
      return 
                "" + Nome +
                " " + Formato  +
                " " + Duracao + 
                " " + PaisOrigem +  
                " " + IdiomaOriginal  +
                " " + EmissoraTv  +
                " " + TransOri  +
                " " + nTemp +
                " " + nEp ;
                
   }

    //metodo para imprimir os atributos
   public void imprimir(){
      System.out.println(this.getNome()+" "+this.getFormato() + " " + this.getDuracao() + " " + this.getPaisOrigem() + " " + this.getIdiomaOriginal()+ " " + this.getEmissoraTv() + " " + this.getTransOri() + " " + this.getnTemp() + " " + this.getnEp());
   }

   //retorna a string que chegou pegando soh o que nao esta entre as tags
   public String limpaString(String linha){
      String resp = "";
      boolean tof = false;
   
      for(int i=0; i<linha.length(); i++){
         if(linha.charAt(i) == '<'){
            tof = true;
         }
      
         if(!tof){
            resp+=linha.charAt(i);
         }
      
         if(linha.charAt(i) == '>'){
            tof = false;
         }
      }
   
      return resp;
   }

   //retorna a string que chegou tirando os caracteres especiais dela;
   public String limpaString1(String linha){
      String resp = "";
      boolean tof = false;
   
      for(int i=0; i<linha.length(); i++){
         if(linha.charAt(i) == '&'){
            tof = true;
         }
      
         if(!tof){
            resp+=linha.charAt(i);
         }
      
         if(linha.charAt(i) == ';'){
            tof = false;
         }
      }
   
      return resp;
   }

   //metodo feito para pegar apenas o numero que estah no comeco da String(o numero que precisa SEMPRE vai estar na pos 0);
   public String pegarNumero(String linha){
      String array[] = linha.split(" ");
      String resp = array[0];
      return resp;
   }

   //metodo recebe o nome do arquivo html, retira as '_' e tambem retira o ".html", retornando apenas o nome;
   public String acharNome(String linha){
      String nome = linha.replace("_" , " ");
      String resp = "";
      int i = 0;
      while(nome.charAt(i) != '.'){
         resp += nome.charAt(i);
         i++;
      }
      return resp;
   }

   //metodo que retorna uma string com o formato da serie;
   public String acharFormato(String linha){
      String formato = limpaString(linha);
      return formato;
   }

   
   //metodo que retorna uma string com a duracao da serie;
   public String acharDuracao(String linha){
      String duracao = limpaString(linha);
      return duracao;
   }

   //metodo que retorna uma string com o pais de origem da serie;
   public String acharPaisOrigem(String linha){
      String paisOrigem = limpaString(linha);
      String paisOrigemResp = limpaString1(paisOrigem);
      return paisOrigemResp.trim();
   }

   //metodo que retorna uma string com o idioma original da serie;
   public String acharIdioma(String linha){
      String idioma = limpaString(linha);
      return idioma.trim();
   }

   //metodo que retorna uma string com a Emissora de tv da serie;
   public String acharEmissora(String linha){
      String emissora = limpaString(linha);
      return emissora.trim();
   }

   //metodo que retorna uma string com a transmissao original da serie;
   public String acharTransOri(String linha){
      String transOri = limpaString(linha);
      String transOriResp = limpaString1(transOri);
      return transOriResp.trim();
   }

   //metodo que retorna um inteiro contendo o numero de temporadas da serie;
   public int acharNumeroTemp(String linha){
      String tmp = limpaString(linha);
      String temp1 = pegarNumero(tmp);
      int tempResp = Integer.parseInt(temp1);
      return tempResp;
   }

   //metodo que retorna um inteiro contendo o numero de episodios da serie;
   public int acharNumeroEps(String linha){
      String ep = limpaString(linha);
      String ep1 = pegarNumero(ep);
      int epResp = Integer.parseInt(ep1);
      return epResp;
   }


   //metodo que abre o arquivo html, pega a linha que precisa e manda para o metodo correspondente, depois seta a informacao necessaria; 
   public void lerArquivos(String nomeArq){
      String linha = "";
      Arq.openRead("/tmp/"+nomeArq);
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("<h1") ; linha = Arq.readLine() );
      this.setNome(acharNome(nomeArq));   
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Formato<") ; linha = Arq.readLine() );
      linha = Arq.readLine(); 
      this.setFormato(acharFormato(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Duração") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setDuracao(acharDuracao(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("País de origem") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setPaisOrigem(acharPaisOrigem(linha));
      if(nomeArq.equals("Grey's_Anatomy.html")){
         this.setPaisOrigem("Estados Unidos"+" ");
      } 
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Idioma original") ; linha = Arq.readLine() );  
      linha = Arq.readLine();
      this.setIdiomaOriginal(acharIdioma(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Emissora de televisão original") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setEmissoraTv(acharEmissora(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Transmissão original") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setTransOri(acharTransOri(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("N.º de temporadas"); linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setnTemp(acharNumeroTemp(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("N.º de episódios"); linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setnEp(acharNumeroEps(linha));     
      Arq.close();
   }
}//fim da class Series

class Lista{
   
   //atributos;
   private int cont; //sempre aponta para uma pos vazia do array;
   private Series array[];
   public int comparacao = 0;
   public int mov = 0;


   //construtores da class Lista;
   public Lista(){
      this(100);
   }

   public Lista(int tam){
      array = new Series[tam];
      cont = 0;//lista acabou de ser criada, logo cont = 0;
   }

   //metodo que insere o objeto na primeira pos da lista e remaneja os demais;
   public void inserirInicio(Series serie)throws Exception{
      if(cont >= array.length){
         throw new Exception("Erro ao inserir");//array cheio
      }
   
      for (int i = cont ; i > 0 ; i-- ) {
         array[i] = array[i-1];
      }
   
      array[0] = serie.clone();
      cont++;
   }

   //metodo que insere o objeto na posicao solicitada e remaneja os demais;
   public void inserir(Series serie , int pos)throws Exception{
      if(cont >= array.length || pos < 0 || pos > cont){
         throw new Exception("Erro ao inserir");//array cheio
      }
   
      for (int i = cont ; i>pos ; i--) {
         array[i] = array[i-1];
      }
      array[pos] = serie.clone();
      cont++;
      
   }

   //metodo que insere o objeto no fim da lista;
   public void inserirFim(Series serie)throws Exception{
      if(cont >= array.length){
         throw new Exception("Erro ao inserir");//array cheio
      }
   
      array[cont] = serie.clone();
      cont++;
   }

   //metodo que remove e retorna o primeiro objeto cadastrado na lista e remaneja os demais;
   public Series removerInicio()throws Exception{
      if(cont == 0){
         throw new Exception("Erro ao remover");//array vazio
      }
   
      Series tmp = array[0];
      cont--;
      for (int i = 0;i<cont ;i++ ) {
         array[i] = array[i+1];
      }
      MyIO.println("(R) "+tmp.getNome());     
      return tmp;
   }

   //metodo que remove(na pos desejada) e retorna o objeto cadastrado na lista e remaneja os demais;
   public Series remover(int pos)throws Exception{
      if(cont == 0 || pos < 0 || pos >= cont){
         throw new Exception("Erro ao remover");//array vazio
      }
   
   
      Series tmp = array[pos];
      cont--;
      for (int i = pos;i<cont ;i++ ) {
         array[i] = array[i+1];
      }
      MyIO.println("(R) "+tmp.getNome());
      return tmp;
      
   }

   //metodo que remove e retorna o ultimo objeto cadastrado na lista;
   public Series removerFim()throws Exception{
      if(cont == 0){
         throw new Exception("Erro ao remover");//array vazio
      }
   
      
      MyIO.println("(R) "+array[cont - 1].getNome());
      return array[--cont];
   }

   //Mostra os elementos da lista separados por espacos.
   public void mostrar(){
      for(int i = 0; i < cont ;i++ ){
         MyIO.println(array[i] + " ");
      }
   }
   
   //retorna true se a string J for maior que a String I;
   public boolean compararString(String j, String i){
      boolean tof = false;
      int resp = j.compareTo(i);
      if (resp > 0) { //se a String J for maior que a I
         tof = true; 
      }
      comparacao++;
      return tof;
      
   }

   //retorna true se a string i for maior que a string j;
   public boolean compararString1(String j, String i){
      boolean tof = false;
      int resp = j.compareTo(i);
      if (resp < 0) {
         tof = true; 
      }
      comparacao++;
      return tof;
      
   }
   
   //retorna true se duas strings forem iguais
   public boolean stringIgual(String j , String i){
      boolean tof = false;
      if(j.equals(i)){
         tof = true;
      }			
      comparacao++;
      return tof;
      
   }

  //algoritmo de ordenacao bolha;
  public void bolha() {
      for (int i = (cont - 1); i > 0; i--) {
         for (int j = 0; j < i; j++) {
            comparacao++;
            if (ehMaior(array[j].getnTemp() , array[j + 1].getnTemp() , array[j] , array[j+1])) {
               Series tmp = array[j];
               array[j] = array[j+1];
               array[j+1] = tmp;
               mov++;
            }
         }
      }
   }

   //verifica qual nTemp eh maior, se os dois forem iguais, vamos olhar o atributo nome;
   public boolean ehMaior(int i, int j, Series x, Series y){
        boolean tof = false;
        //int comp = a.compareTo(b);
        
        if(i > j){
            tof = true;
         }
         else if(i == j){
            if( compararString(x.getNome() , y.getNome()) ){
               tof = true;
            }
            
         }
         return tof;
   }

 

}//fim da class Lista;

class TP05Q10{
   public static void main(String[] args)throws Exception{
      MyIO.setCharset("UTF-8");
      Series S = new Series();
      Lista L = new Lista();
      //leitura da primeira parte da entrada;
      String entrada = MyIO.readLine();
      int qtEntrada = 0;
      while(entrada.equals("FIM") == false){
         S.lerArquivos(entrada);
         L.inserirFim(S);
         entrada = MyIO.readLine();
      }//fim while
      long inicio = System.currentTimeMillis();
      L.bolha();
      long fim = System.currentTimeMillis(); 
   		
      
      L.mostrar();
   
      Arq.openWrite("576473_bolha.txt", "UTF-8");
      Arq.println("Matricula: 576473\tTempo:" + (fim-inicio)/1000.0 + "s\t" + "Compracoes:"+L.comparacao+"\t"+"Movimentacoes:"+L.mov); 
      Arq.close();
   
   }
}
