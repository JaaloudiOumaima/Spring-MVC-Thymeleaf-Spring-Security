package my.hospital.hospitalapp.repositories;

import lombok.AllArgsConstructor;
import my.hospital.hospitalapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private final PatientRepository patientRepository;
    PatientRepository PatientRepository;

    @GetMapping("/index")
    public String getIndex(Model model,
                           @RequestParam(name = "p",defaultValue = "0") int page,
                           @RequestParam(name = "s",defaultValue = "5") int size,
                           @RequestParam(name = "Keyword",defaultValue = "") String Kw) {
        //Page<Patient> Pagepatients = PatientRepository.findAll(PageRequest.of(page,size));
        Page<Patient> Pagepatients = PatientRepository.Search(Kw,PageRequest.of(page,size));
        model.addAttribute("ListPatients",Pagepatients.getContent());
        model.addAttribute("page",new int[Pagepatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("Keyword",Kw);
        return "patients";
    }
    @GetMapping("/delete")
    public String deletePatient(Long id,String Keyword,int page) {
        patientRepository.deleteById(id);
        return "redirect:/index?page"+page+"&Keyword="+Keyword;
    }
}
