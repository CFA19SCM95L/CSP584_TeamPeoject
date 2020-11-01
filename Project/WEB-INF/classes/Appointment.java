import java.util.*;
import java.util.Map;
import java.time.*;


/*providerId integer,
customerId integer,
appointmentDate date,
appointmentTime time*/

public class Appointment{
	private int providerId;
	private int customerId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	

	public Appointment(int providerId, int customerId, LocalDate appointmentDate,LocalTime appointmentTime){
		this.providerId=providerId;
		this.customerId=customerId;
		this.appointmentDate=appointmentDate;
		this.appointmentTime=appointmentTime;
	}

	public Appointment(){
		
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime =appointmentTime;
	}
}