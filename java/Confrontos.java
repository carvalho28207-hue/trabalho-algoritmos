public class Confrontos {
    public static void main(String[] args) {

        // Parte A
        String[] times = { "Atlético-MG", "Cruzeiro", "América-MG", "Villa Nova"};

        // Parte B
        for (int i = 0; i < times.length; i++){
            System.out.println(i + " - " + times[i]);
        }

        // RF-02
        int totalJogos = 0;

        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times.length; j++) {
                if (i != j){
                System.out.println(times[i] + " x " + times[j]);
                totalJogos++;
             }
          }
      }
      System.out.println("Total de jogos: "+ totalJogos);

      // RF-05
      int totalUnico = 0;
      for (int i = 0; i < times.length; i++) {
        for (int j = 0; j < times.length; j++) {
            if (i < j) {
                System.out.println(times[i] + " x "+ times[j]);
                totalUnico++;
            }
        }
      }
      System.out.println("Total turno único: "+ totalUnico);

      // Parte 4: novo array com 5 posições, cópia por repetição e novo time
      String[] timesNovos = new String[5];
      for (int i = 0; i < times.length; i++) {
        timesNovos[i] = times[i];
      }
      timesNovos[4] = "Tombense";
      times = timesNovos;

      System.out.println();
      System.out.println("=== Com 5 times (Tombense) ===");
      for (int i = 0; i < times.length; i++){
          System.out.println(i + " - " + times[i]);
      }

      totalJogos = 0;
      for (int i = 0; i < times.length; i++) {
          for (int j = 0; j < times.length; j++) {
              if (i != j) {
                  System.out.println(times[i] + " x " + times[j]);
                  totalJogos++;
              }
          }
      }
      System.out.println("Total de jogos: "+ totalJogos);

      totalUnico = 0;
      for (int i = 0; i < times.length; i++) {
          for (int j = 0; j < times.length; j++) {
              if (i < j) {
                  System.out.println(times[i] + " x "+ times[j]);
                  totalUnico++;
              }
          }
      }
      System.out.println("Total turno único: "+ totalUnico);
  }
}

