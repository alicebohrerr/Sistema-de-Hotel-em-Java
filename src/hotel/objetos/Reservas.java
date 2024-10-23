package hotel.objetos;

import java.util.ArrayList; 
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 
public class Reservas {
	
	private Hospede hospede;
	private LocalDate dataCheckIn;
	private LocalDate dataCheckOut;
	private List<Quartos> quartosReservados = new ArrayList<>();
	static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public Reservas() {

	}
	
	public void adicionarQuarto(Quartos quarto) {

        this.quartosReservados.add(quarto);
    }


	public Hospede getHospede() {
		return hospede;
	}


	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}


	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}


	public void setDataCheckIn(String dataCheckIn) {
		this.dataCheckIn = LocalDate.parse(dataCheckIn, formatter);
	}


	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}


	public void setDataCheckOut(String dataCheckOut) {
		this.dataCheckOut = LocalDate.parse(dataCheckOut, formatter);
	}


	public List<Quartos> getQuartosReservados() {
		return quartosReservados;
	}


	public void setQuartosReservados(List<Quartos> quartosReservados) {
		this.quartosReservados = quartosReservados;
	}


	@Override
	public String toString() {
		return "Reservas [hospede=" + hospede + ", dataCheckIn=" + dataCheckIn.format(formatter) + ", dataCheckOut=" + dataCheckOut.format(formatter)
				+ ", quartosReservados=" + quartosReservados + "]";
	}

}
