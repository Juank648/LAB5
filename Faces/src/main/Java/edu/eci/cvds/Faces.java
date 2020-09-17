package edu.eci.cvds;

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
public class Faces{
	private ArrayList<Double> datosIngresados;
	private double media;
	private double standardDesviation;
	private double variance;
	private double mode;
	private int cantidadNumeros;
	
	public Faces(){
		datosIngresados = new ArrayList<Double>();
		media = 0;
		standardDesviation = 0;
		variance = 0;
		mode = 0;
		cantidadNumeros = 0;
	}
	
	public void setdatosIngresados(ArrayList <Double> datosIngresados){
		this.datosIngresados = datosIngresados;
	}
	
	public double getMedia(){
		return media;
	}
	public double getStandardDesviation(){
		return standardDesviation;
	}
	public double getVariance(){
		return variance;
	}
	public double getMode(){
		return mode;
	}
	
	
	public void setcantidadNumeros(int cantidadNumeros){
		this.cantidadNumeros = cantidadNumeros;
	}
	
	public double calculateMean(ArrayList<Double> lista){
		double res = 0; 
		for(int i = 0; i<lista.size();i++){
			res += lista.get(i);
		}
		res = res/lista.size();
		this.media = res;
		return res;
	}
	
	public double calculateStandardDeviation(ArrayList<Double> lista){
		double med = 0;
		med = calculateMean(lista);
		double x = 0; 
		for(int i = 0; i<lista.size();i++){
			double y = 0;
			y = lista.get(i) - med;
			x += y*y;
		}
		x = Math.sqrt(x/lista.size());
		this.standardDesviation = x;
		return x;
	}
	
	public double calculateVariance(ArrayList<Double> lista){
		double med = 0;
		med = calculateMean(lista);
		double x = 0; 
		for(int i = 0; i<lista.size();i++){
			double y = 0;
			y = lista.get(i) - med;
			x += y*y;
		}
		x = x/lista.size();
		this.variance = x;
		return x;
	}
	
	public double calculateMode(ArrayList<Double> lista){
		int maximoNumRepeticiones= 0;
        double moda= 0;
		for(int i=0; i<lista.size(); i++)
		{
			int numRepeticiones= 0;
			for(int j=0; j<lista.size(); j++)
			{
				if(lista.get(i)==lista.get(j))
				{
					numRepeticiones++;
				}   //fin if
				if(numRepeticiones>maximoNumRepeticiones)
				{
					moda= lista.get(i);
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
		this.cantidadNumeros = 0;
	}
	
}