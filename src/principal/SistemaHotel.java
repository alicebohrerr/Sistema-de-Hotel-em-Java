package principal;

import hotel.objetos.Quartos;
import hotel.objetos.Reservas;
import hotel.objetos.Hospede;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SistemaHotel {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Quartos> listaQuartos = new ArrayList<>();
	static ArrayList<Reservas> listaReservas = new ArrayList<>();
	static ArrayList<Hospede> listaHospedes = new ArrayList<>();
	static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


	public static void main(String[] args) {
		
		menuPrincipal();

	}
	
	static public void menuPrincipal() {
		
		while (true) {
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Boas vindas ao gerênciador do Hotel!");
			System.out.println("Escolha a Opção a seguir para navegar no sistema:");
			System.out.printf("\n");
			System.out.println("1 - Gerenciar quartos.");
			System.out.println("2 - Gerenciar Reservas.");
			System.out.println("3 - Registrar Check-in.");
			System.out.println("4 - Registrar Check-out.");
			System.out.println("5 - Relatório de ocupação.");
			System.out.println("6 - Histórico de reservas.");
			System.out.println("7 - Cadastrar Hóspede.");
			System.out.println("8 - Sair.");
			
			int escolhaUsuario = scan.nextInt();
			scan.nextLine();
			
			if(escolhaUsuario == 1) {
				gerenciarQuartos();
				
			} else if (escolhaUsuario == 2) {
				gerenciarReservas();
			} else if (escolhaUsuario == 3) {
				registrarCheckIn();
			} else if (escolhaUsuario == 4) {
				registrarCheckOut();
			} else if ( escolhaUsuario == 5) {
				relatorioOcupacao();
			} else if (escolhaUsuario == 6) {
				historico();
			} else if (escolhaUsuario == 7) {
				gerenciarHospede();
			} else if (escolhaUsuario == 8) {
				System.out.println("Deseja mesmo sar do sistema?");
				System.out.println("1 - Para sair e encerrar.");
				System.out.println("2 - Para voltar ao menu principal.");
				int escolhaSair = scan.nextInt();
				scan.nextLine();
				
				if(escolhaSair == 1) {
					System.out.println("Saindo do sistema...");
					System.out.println("Sistema encerrado.");
					
					System.exit(0);
				} else if (escolhaSair == 2) {
					menuPrincipal();
				} else {
					System.out.println("Opção inválida, tente novamente.");
					
				}
				
			} else {
				System.out.println("Opção inválida, tente novamente entre 1 a 7.");
			}
		}
		
	}
	
	static public void gerenciarHospede() {
		System.out.println("-------------------------------------------------------------");
		
		System.out.println("Gerenciar Hóspedes");
		System.out.printf("\n");
		System.out.println("Digite a opção desejada.");
		System.out.println("1 - Cadastrar novo hóspede");
		System.out.println("2 - Listar hóspedes");
		System.out.println("0 - Voltar");
		
		int escolhaUsuario = scan.nextInt();
		scan.nextLine();
		
		if (escolhaUsuario == 1) {
			cadastrarHospede();
		} else if (escolhaUsuario == 2) {
			System.out.println("Lista de hóspedes");
			System.out.printf("\n");
			
			if (listaHospedes.isEmpty()) {
				System.out.println("Nenhum hospede cadastrado, tente novamente.");
				gerenciarHospede();
			} else {
				for (Hospede listarHospedes : listaHospedes) {
					System.out.println(listarHospedes);
				}
			}
		} else if (escolhaUsuario == 0) {
			menuPrincipal();
		} else {
			System.out.println("Opção inválida, tente novamente.");
			gerenciarHospede();
		}
	}
	
	static public void gerenciarQuartos() {
		System.out.println("-------------------------------------------------------------");

		System.out.println("Menu dos Quartos");
		System.out.printf("\n");
		System.out.println("Digite a opção desejada.");
		System.out.println("1 - Cadastrar quarto");
		System.out.println("2 - Listar quartos");
		System.out.println("0 - Voltar");
		
		int escolhaUsuario = scan.nextInt();
		scan.nextLine();
		
		if (escolhaUsuario == 1) {
			System.out.println("Preencha as opções a seguir para cadastrar um quarto.");
			System.out.printf("\n");
			
			Quartos quarto = new Quartos();
			
			System.out.println("Número do quarto");
			quarto.setNumeroQuarto(scan.nextInt());
			scan.nextLine();
			System.out.println("Tipo do quarto (1-Solteiro, 2-Casal, 3-Suite");
			int tipoQuarto = scan.nextInt();
			scan.nextLine();
			if(tipoQuarto == 1) {
				quarto.setTipoQuarto("Solteiro");
			} else if(tipoQuarto == 2) {
				quarto.setTipoQuarto("Casal");
			} else if(tipoQuarto == 3) {
				quarto.setTipoQuarto("Suíte");
			} else {
				System.out.println("Opção inválida, tente novamente.");
				gerenciarQuartos();
			}
			
			System.out.println("Preço da Diaria");
			quarto.setPrecoDiaria(scan.nextDouble());
			scan.nextLine();
			quarto.setDisponivel(true);
			
			listaQuartos.add(quarto);
			System.out.println("Quarto adicionado com sucesso!");
			gerenciarQuartos();
			
		} else if (escolhaUsuario == 2) {
			System.out.println("Lista dos Quartos");
			System.out.printf("\n");
			
			if(listaQuartos.isEmpty()) {
				System.out.println("Nenhum quarto cadastrado!");
				gerenciarQuartos();
			} else { 
				for (Quartos listarQuartos : listaQuartos) {
					System.out.println(listarQuartos);
				}
			}
		} else if (escolhaUsuario == 0) {
			menuPrincipal();
		} else {
			System.out.println("Opção inválida, tente novamente.");
			gerenciarQuartos();
		}
		
	}
	
	static public void gerenciarReservas() {
		System.out.println("-------------------------------------------------------------");

		System.out.println("Gerenciar Reservas");
		System.out.printf("\n");
		System.out.println("Digite a opção desejada.");
		System.out.println("1 - Cadastrar reserva");
		System.out.println("2 - Listar reservas");
		System.out.println("0 - Voltar");
		int escolhaUsuario = scan.nextInt();
		scan.nextLine();
		
		if(escolhaUsuario == 1) {
			Reservas reserva = new Reservas();
			
			System.out.println("Digite o CPF do hóspede:");
			String cpf = scan.next();
			scan.nextLine();
			
			Hospede hospede = encontrarHospede(cpf);
			if (hospede == null) {
				System.out.println("Hóspede não encontrado. Cadastre o hóspede primeiro.");
				cadastrarHospede();
				hospede = encontrarHospede(cpf);
				
				if (hospede == null) {
					System.out.println("Hóspede não encontrado. A reserva não pode ser concluída.");
					gerenciarReservas();
				}
			}
			
			reserva.setHospede(hospede);
			
			try {
	            System.out.println("Data de check-in (dd/MM/aaaa):");
	            String dataCheckIn = scan.next();
	            reserva.setDataCheckIn(dataCheckIn);



	            System.out.println("Data de check-out (dd/MM/aaaa):");
	            String dataCheckOut = scan.next();
	            reserva.setDataCheckOut(dataCheckOut);
	            scan.nextLine();


	        } catch (DateTimeParseException e) {
	            System.out.println("Formato de data inválido. Use dd/MM/aaaa");
	            return;
	        }
			
			
			System.out.println("Números dos quartos a reservar (separados por vírgula):");
	        String[] numerosQuartos = scan.nextLine().split(",");

	        for (String numQuartos : numerosQuartos) {
	            try {
	                int numQuarto = Integer.parseInt(numQuartos.trim());
	                Quartos quarto = encontrarQuarto(numQuarto);
	                if (quarto != null && quarto.isDisponivel()) {
	                    reserva.adicionarQuarto(quarto);
	                    quarto.setDisponivel(false);
	                } else {
	                    System.out.println("Quarto " + numQuarto + " inválido ou indisponível.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Número de quarto inválido: " + numQuartos);

	            }
	        }

	        if (reserva.getQuartosReservados().isEmpty()) {
	            System.out.println("Nenhum quarto foi reservado com sucesso. Reserva cancelada.");
	            return;
	        }
	        
	        listaReservas.add(reserva);
	        System.out.println("Reserva Cadastrada com sucesso!");

		} else if(escolhaUsuario == 2) {
			System.out.println("Lista das reservas!");
			System.out.printf("\n");
			
			if(listaReservas.isEmpty()) {
				System.out.println("Nenhuma reserva encontrada!");
				gerenciarReservas();
			} else {
				for(Reservas listarReservas : listaReservas) {
					System.out.println(listarReservas);
				}
			}
		} else if (escolhaUsuario == 0) {
			menuPrincipal();
		} else {
			System.out.println("Opção inválida, tente novamente!");
			gerenciarReservas();
		}
	}
	
	static public void registrarCheckIn() {
		
		System.out.println("Digite o CPF do hóspede para check-in:");
		String cpfHospede = scan.nextLine();
		Hospede hospede = encontrarHospede(cpfHospede);
		
		if (hospede == null) {
            System.out.println("Hóspede não encontrado.");
            return;
        }
		
		System.out.println("Digite o número do quarto para check-in: ");
        int numQuarto = scan.nextInt();
        
        Quartos quarto = encontrarQuarto(numQuarto);
        Reservas reservaDoHospede = encontrarReservaPorHospedeEQuarto(hospede, quarto);
        
        if (reservaDoHospede != null && quarto != null && quarto.isDisponivel()) { 
            quarto.setDisponivel(false);
            System.out.println("Check-in realizado com sucesso para o hóspede " + hospede.getNome() + " no quarto " + numQuarto + "!");

        } else {
            if (quarto == null) {
                System.out.println("Quarto não encontrado!");
            } else if (!quarto.isDisponivel()) {
                System.out.println("Quarto já ocupado!");
            } else if (reservaDoHospede == null) {
                System.out.println("Hóspede " + hospede.getNome() + " não possui reserva para o quarto "+ numQuarto + "!");
            }
        }

	}
	
	static public void registrarCheckOut() {
		
		System.out.println("Digite o CPF do hóspede para check-out:");
        String cpfHospede = scan.next();
        
        Hospede hospede = encontrarHospede(cpfHospede);
        if (hospede == null) {
            System.out.println("Hóspede não encontrado.");
            return;
        }
        
        System.out.println("Digite o número do quarto para check-out: ");
        try {
            int numQuarto = scan.nextInt();
            Quartos quarto = encontrarQuarto(numQuarto);



            if (quarto != null && !quarto.isDisponivel()) {

                
                Reservas reserva = encontrarReservaPorHospedeEQuarto(hospede, quarto);
                if (reserva != null) {
                    quarto.setDisponivel(true);
                    System.out.println("Check-out realizado com sucesso para o hóspede " + hospede.getNome() + " no quarto " + numQuarto + "!");

                } else {
                    System.out.println("Hóspede não está associado a este quarto. Check-out não permitido.");
                }

            } else {
                if (quarto == null) {
                    System.out.println("Quarto não encontrado.");
                } else {
                    System.out.println("Quarto já está disponível (não ocupado).");
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número válido para o quarto.");
            scan.next();
        }
		
	}
	
	static public void relatorioOcupacao() {
		
		System.out.println("Relatório de ocupação");
		System.out.printf("\n");
		
		System.out.println("Digite a data inicial (dd/MM/aaaa):");
        String dataIniciall = scan.next();

        System.out.println("Digite a data final (dd/MM/aaaa):");
        String dataFinall = scan.next();

        LocalDate dataInicial;
        LocalDate dataFinal;

        try {
            dataInicial = LocalDate.parse(dataIniciall, formatter);
            dataFinal = LocalDate.parse(dataFinall, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Use dd/MM/aaaa");
            return;
        }

        System.out.println("Relatório de ocupação de " + dataInicial.format(formatter) + " a " + dataFinal.format(formatter));

        for (Quartos quarto : listaQuartos) {
            for (Reservas reserva : listaReservas) {

                if (reserva.getQuartosReservados().contains(quarto) &&
                        !reserva.getDataCheckIn().isAfter(dataFinal) &&
                        !reserva.getDataCheckOut().isBefore(dataInicial)) {


                    System.out.println("Quarto " + quarto.getNumeroQuarto() + " (" + quarto.getTipoQuarto() + ") - " +
                            "Ocupado por " + reserva.getHospede().getNome() +
                            " (Check-in: " + reserva.getDataCheckIn().format(formatter) +
                            ", Check-out: " + reserva.getDataCheckOut().format(formatter) + ")");
                    break;
                }
            }
        }
    }

	
	static public void historico() {
		
		System.out.println("Digite o CPF do hóspede:");
        String cpf = scan.next(); 
        Hospede hospede = encontrarHospede(cpf);
        
        if (hospede == null) {
            System.out.println("Hóspede não encontrado.");
            return;
        }
        
        System.out.println("Histórico de reservas para " + hospede.getNome() + " (CPF: " + hospede.getCpf() + "):");
        
        for (Reservas reserva : listaReservas) {
            if (reserva.getHospede().equals(hospede)) {
                System.out.println(reserva);
            }
        }
    }

	static void cadastrarHospede() {

        Hospede hospede = new Hospede();

        System.out.println("Nome do hóspede:");
        hospede.setNome(scan.next());
        scan.nextLine();


        System.out.println("CPF do hóspede:");
        String cpf = scan.nextLine();
        
        
        if (cpf.length() == 11) {
             hospede.setCpf(cpf);
        }
        else {
             System.out.println("CPF inválido. O CPF deve ter 11 dígitos.");
            return; 
        }
        listaHospedes.add(hospede);
        System.out.println("Hóspede cadastrado com sucesso!");
    }
	
	static Quartos encontrarQuarto(int numQuarto) {
		for(Quartos listarQuarto : listaQuartos) {
			if(listarQuarto.getNumeroQuarto() == numQuarto) {
				return listarQuarto;
			}
		}
		return null;
		
	}
	
	static Hospede encontrarHospede(String cpf) {
        for (Hospede listarHospedes : listaHospedes) {
            if (listarHospedes.getCpf().equals(cpf)) {
                return listarHospedes;
            }
        }
        return null;
    }

	static Reservas encontrarReservaPorHospedeEQuarto(Hospede hospede, Quartos quarto) {
        if (hospede == null || quarto == null) {
            return null;
        }

        for (Reservas reserva : listaReservas) {
            if (reserva.getHospede().equals(hospede) && reserva.getQuartosReservados().contains(quarto)) {
                return reserva;
            }
        }
        return null;
    }
	
}
