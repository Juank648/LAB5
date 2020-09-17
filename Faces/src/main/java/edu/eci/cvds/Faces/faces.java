package edu.eci.cvds.Faces;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class faces{
	private ArrayList<Float> datosIngresados;
	private float media;
	private float standardDesviation;
	private float variance;
	private float mode;
	public String cantidadNumeros;
	public float prueba;
	
	public faces(){
		datosIngresados = new ArrayList<Float>();
		media = 0.0;
		standardDesviation = 0.0;
		variance = 0.0;
		mode = 0.0;
		cantidadNumeros = "";
		prueba = 0.0;
	}
	
	public float getPrueba() {
		return prueba;
	}
	
	public void setDatosIngresados(ArrayList <Float> datosIngresados){
		this.datosIngresados = datosIngresados;
	}
	
	public ArrayList<Float> getDatosIngresados() {
		return datosIngresados;
	}
	
	public float getMedia(){
		return media;
	}
	public float getStandardDesviation(){
		return standardDesviation;
	}
	public float getVariance(){
		return variance;
	}
	public float getMode(){
		return mode;
	}
	
	
	public void setCantidadNumeros(String cantidadNumeros){
		this.cantidadNumeros = cantidadNumeros;
	}
	
	public String getCantidadNumeros() {
		return cantidadNumeros;
	}

	public ArrayList<Float> convertirString() {
		String pend = "";
		for(int i = 0; i < cantidadNumeros.length(); i++) {
			char t = ';';
			if(cantidadNumeros.charAt(i) == t) {
				float doble=Float.parseFloat(pend)
				datosIngresados.add(doble);
				pend = "";
			}else {
				pend +=  cantidadNumeros.charAt(i);
			}
		}
		return datosIngresados;
	}
	
	public double calculateMean(){
		//datosIngresados = convertirString();
		double res = 0.0; 
		for(int i = 0; i<datosIngresados.size();i++){
			res += datosIngresados.get(i);
		}
		//res = res/datosIngresados.size();
		this.media = res;
		return res;
	}
	
	public double calculateStandardDeviation(){
		//datosIngresados = convertirString();
		double med = 0;
		med = calculateMean();
		double x = 0; 
		for(int i = 0; i<datosIngresados.size();i++){
			double y = 0;
			y = datosIngresados.get(i) - med;
			x += y*y;
		}
		x = Math.sqrt(x/datosIngresados.size());
		this.standardDesviation = x;
		return x;
	}
	
	public double calculateVariance(){
		//datosIngresados = convertirString();
		double med = 0;
		med = calculateMean();
		double x = 0; 
		for(int i = 0; i<datosIngresados.size();i++){
			double y = 0;
			y = datosIngresados.get(i) - med;
			x += y*y;
		}
		x = x/datosIngresados.size();
		this.variance = x;
		return x;
	}
	
	public double calculateMode(){
		//datosIngresados = convertirString();
		int maximoNumRepeticiones= 0;
        double moda= 0;
		for(int i=0; i<datosIngresados.size(); i++)
		{
			int numRepeticiones= 0;
			for(int j=0; j<datosIngresados.size(); j++)
			{
				if(datosIngresados.get(i)==datosIngresados.get(j))
				{
					numRepeticiones++;
				}   //fin if
				if(numRepeticiones>maximoNumRepeticiones)
				{
					moda= datosIngresados.get(i);
					maximoNumRepeticiones= numRepeticiones;
				}   //fin if
			}
		}   //fin for
		this.mode = moda;
		return moda;
	}
	public void restart(){
		this.mode = 0;
		this.standardDesviation = 0;
		this.media = 0;
		this.variance = 0;
		this.datosIngresados = null;
		this.cantidadNumeros = "";
	}
	
}