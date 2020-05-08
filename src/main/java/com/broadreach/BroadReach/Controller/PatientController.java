package com.broadreach.BroadReach.Controller;

import com.broadreach.BroadReach.Exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.broadreach.BroadReach.Model.Patient;
import org.springframework.web.bind.annotation.RequestMethod;
import com.broadreach.BroadReach.Service.PatientService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

//Controller Class


@Controller
@RequestMapping("/")
class PatientController {
    
    @Autowired
    PatientService service;
    //Home Page for listing patients
    //localhost:8080
    @RequestMapping
    public String getAllPatients(Model model){
        List<Patient> list = service.getAllPatients();
        model.addAttribute("patients", list);
        return "list-patients";
    }
    //localhost:8080/edit
    @RequestMapping({"/edit", "/edit/{id}"})
    public String editPatientById(Model model, @PathVariable("id") Optional <String> id)
    throws RecordNotFoundException{
        if (id.isPresent()) {
            Patient entity = service.getPatientById(id.get());
            model.addAttribute("patient", entity);
        }else{
           model.addAttribute("patient", new Patient());
        }
        return "add-edit-patient";    
    }
    //Delete Patient
    @RequestMapping(path = "/delete/{id}")
    public String deletePatientById(Model model, @PathVariable("id") String id) 
                            throws RecordNotFoundException 
    {
        service.deletePatientByID(id);
        return "redirect:/";
    }
    //localhost:8080/createPatient
    @RequestMapping(path = "/createPatient", method = RequestMethod.POST)
    public String createOrUpdatePatient(Patient patient) 
    {
        service.createOrUpdatePatient(patient);
        return "redirect:/";
    }

    
    
}

