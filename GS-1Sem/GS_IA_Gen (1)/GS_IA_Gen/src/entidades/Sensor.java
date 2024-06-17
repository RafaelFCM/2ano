package entidades;

public class Sensor{
    
    private String coordenada;
    private double nitrogenio;
    private double fosforo;
    private double potassio;

    public Sensor(String coordenada, double nitrogenio, double fosforo, double potassio) {
		super();
		this.coordenada = coordenada;
		this.nitrogenio = nitrogenio;
		this.fosforo = fosforo;
		this.potassio = potassio;
	}

	public String getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}

	public double getNitrogenio() {
		return nitrogenio;
	}

	public void setNitrogenio(double nitrogenio) {
		this.nitrogenio = nitrogenio;
	}

	public double getFosforo() {
		return fosforo;
	}

	public void setFosforo(double fosforo) {
		this.fosforo = fosforo;
	}

	public double getPotassio() {
		return potassio;
	}

	public void setPotassio(double potassio) {
		this.potassio = potassio;
	}

	@Override
    public String toString() {
    return "Dados do sensor: " + "\n\nCoordenada:" + coordenada  + "\nQntd nitrogenio: " + nitrogenio  + "\nQntd fosforo: " + fosforo  + "\nQntd potassio: " + potassio;
    }
}