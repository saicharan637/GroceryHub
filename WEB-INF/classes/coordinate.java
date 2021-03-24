import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class coordinate{
	double lat;
	double longi;
	int weight;
	
	coordinate(double lat, double longi){
		this.lat = lat;
		this.longi = longi;
		this.weight = 0;
	}

	@Override
    public int hashCode(){ 
		final int temp = 31; 
		int ans = 1; 
		ans = temp * ans + Double.valueOf(lat).hashCode();
		ans = temp * ans + Double.valueOf(longi).hashCode();
		return ans; 
	}
		
	@Override
	public boolean equals(Object co2){
		
		if(co2==null){
			return false;
		}
		if(this == co2){
			return true;
		}
		if(this.getClass()!=co2.getClass()){ 
			return false;
		}
		coordinate temp = (coordinate)co2;
		return this.lat==temp.lat && this.longi==temp.longi;
	}
	
}