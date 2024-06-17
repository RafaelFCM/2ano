package entidades;

public class Sensor{
    
    private String x;
    private String y;
    private double umidade;
    private double pH;
    private double quant_nitrogenio;
    private double quant_fosforo;
    private double quant_potassio;


    public Sensor(String x, String y) {
		this.x = x;
		this.y = y;
	}


	public String getX() {
		return x;
	}


	public void setX(String x) {
		this.x = x;
	}


	public String getY() {
		return y;
	}


	public void setY(String y) {
		this.y = y;
	}


	public double getUmidade() {
		return umidade;
	}


	public void setUmidade(double umidade) {
		this.umidade = umidade;
	}


	public double getpH() {
		return pH;
	}


	public void setpH(double pH) {
		this.pH = pH;
	}


	public double getQuant_nitrogenio() {
		return quant_nitrogenio;
	}


	public void setQuant_nitrogenio(double quant_nitrogenio) {
		this.quant_nitrogenio = quant_nitrogenio;
	}


	public double getQuant_fosforo() {
		return quant_fosforo;
	}


	public void setQuant_fosforo(double quant_fosforo) {
		this.quant_fosforo = quant_fosforo;
	}


	public double getQuant_potassio() {
		return quant_potassio;
	}


	public void setQuant_potassio(double quant_potassio) {
		this.quant_potassio = quant_potassio;
	}
	public String toString() {
        return "X: " + x + "\n" +
               "Y: " + y + "\n" +
               "Umidade: " + umidade + "\n" +
               "pH: " + pH + "\n" +
               "Quantidade de Nitrogenio: " + quant_nitrogenio + "\n" +
               "Quantidade de Fosforo: " + quant_fosforo + "\n" +
               "Quantidade de Potassio: " + quant_potassio + "\n";
    }
	@Override
	public boolean equals(Object obj) {
		Sensor sensor = (Sensor)obj;
		boolean isIgual = false;  
		if(sensor.x.equals(this.x) && sensor.y.equals(this.y)) {
			isIgual = true;
		}
		return isIgual;
	}
}