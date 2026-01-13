package scenario_based.HospitalManagementSystem;

import java.util.HashMap;
import java.util.Map;

// Implementation
public class HospitalServiceImpl implements HospitalService {

    private Map<String, Appointment> appointments = new HashMap<>();

    @Override
    public void bookAppointment(Appointment appointment) throws AppointmentNotAvailableException {
        if (appointments.containsKey(appointment.getTimeSlot())) {
            throw new AppointmentNotAvailableException("Appointment slot not available");
        }
        appointments.put(appointment.getTimeSlot(), appointment);
    }

    @Override
    public void cancelAppointment(String timeSlot) {
        appointments.remove(timeSlot);
        System.out.println("Appointment cancelled for slot: " + timeSlot);
    }
}
