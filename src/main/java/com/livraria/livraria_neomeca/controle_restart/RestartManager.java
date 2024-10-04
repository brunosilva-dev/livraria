package com.livraria.livraria_neomeca.controle_restart;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RestartManager {

  // Variáveis privadas para manter o estado do reinício
  private static LocalDateTime lastRestartTime = null;
  private static int restartCountToday = 0;

  // Formato para exibir a data e hora (pode ser public se for necessário em outro
  // lugar)
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  // Método público para simular o reinício do ambiente
  public static void restartEnvironment() {
    LocalDateTime now = LocalDateTime.now();

    // Verifica se o último reinício foi no mesmo dia
    if (lastRestartTime != null && isSameDay(now, lastRestartTime)) {
      restartCountToday++;
    } else {
      // Se for um novo dia, reseta o contador
      restartCountToday = 1;
    }

    // Atualiza a data e hora do último reinício
    lastRestartTime = now;

    // Exibe as informações do reinício
    System.out.println("Ambiente reiniciado às: " + lastRestartTime.format(formatter));
    System.out.println("Reinícios no dia de hoje: " + restartCountToday);
    System.out.println("");
  }

  // Método privado para verificar se duas datas estão no mesmo dia
  private static boolean isSameDay(LocalDateTime date1, LocalDateTime date2) {
    return date1.toLocalDate().equals(date2.toLocalDate());
  }
}
