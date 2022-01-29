package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o caminho do arquivo: ");
		String path = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			Map<String, Integer> res = new LinkedHashMap<>();
			String line = br.readLine();
			while (line != null) {
				String [] dados = line.split(",");
				String nomeCandidato = dados[0];
				int votos = Integer.parseInt(dados[1]);
				
				if (res.containsKey(nomeCandidato)) {
					int totVotos = res.get(nomeCandidato);
					res.put(nomeCandidato, votos + totVotos);
				}
				else {
					res.put(nomeCandidato, votos);
				}
				line = br.readLine();
			}
			
			for (String cand : res.keySet()) {
				System.out.println(cand + ": " + res.get(cand));
			}
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();

	}

}
