package my.hospital.hospitalapp;

import my.hospital.hospitalapp.entities.Patient;
import my.hospital.hospitalapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalAppApplication  implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {

		SpringApplication.run(HospitalAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Oumaima",new Date(),false,250));
		patientRepository.save(new Patient(null,"Imane",new Date(),false,300));
		patientRepository.save(new Patient(null,"Mariam",new Date(),false,100));
	}
}
