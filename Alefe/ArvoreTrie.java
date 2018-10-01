class ArvoreTrie{
   //FUNCIONAMENTO DO PESQUISAR;
   
   /*Verificar se o char que ta no No eh null, se for null return false;
     Verificar se i == s.length - 1 
     (se no.array[charAt(i)] for uma folha, return true;)
     Verificar se i < s.length - 1
     chamar o metodo recursivo
     else{
      //Erro
     }
   */
   
     public boolean pesquisar(String s){
         return pesquisar(s,raiz,0);
     } 
     
     private boolean pesquisar(String s , No no , int i){
         boolean tof;
         
         if(no.prox[s.charAt(i)] == null){
            resp = false;
         }
         else if(i == s.length - 1){
            resp = (no.prox[s.charAt(i)].folha == true)
         }
         else if(i < s.length - 1){
            resp = pesquisar(s , no.prox[s.charAt(i)] , i + 1);
         }
         else{
            //erro
         }
         
         return resp;
     }

}