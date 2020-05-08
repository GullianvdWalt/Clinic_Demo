/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.broadreach.BroadReach.Service;

import com.broadreach.BroadReach.Exception.RecordNotFoundException;
import com.broadreach.BroadReach.Repository.PatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.broadreach.BroadReach.Model.Patient;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class PatientService {
    
    @Autowired
    PatientRepository patientRepo;
    
    public List<Patient> getAllPatients(){
        List<Patient> result = (List<Patient>) patientRepo.findAll();
        
        if(result.size() > 0){
            return result;
        }else{
            return new ArrayList<Patient>(); 
        }
    }
    public Patient getPatientById(String id) throws RecordNotFoundException{
        Optional<Patient> patient = patientRepo.findById(id);
        
        if(patient.isPresent()){
            return patient.get();
        }else{
            throw new RecordNotFoundException("No patient record exist for given id");
        }
    }
    
    public Patient createOrUpdatePatient(Patient entity){
        if(entity.getId() == null){
            entity = patientRepo.save(entity);
            return entity;
        }else{
            Optional<Patient> patient = patientRepo.findById(entity.getId());
            
            if(patient.isPresent()){
                Patient newEntity = patient.get();
                newEntity.setId(entity.getId());
                newEntity.setPatientName(entity.getPatientName());
                newEntity.setPatientSurname(entity.getPatientSurname());
                newEntity.setDOB(entity.getDOB());
                newEntity.setGender(entity.getGender());
                newEntity.setAddress(entity.getAddress());
                newEntity.setCell(entity.getCell());
                newEntity.setEmrgContact(entity.getEmrgContact());
                newEntity.setEmrgContactCell(entity.getEmrgContactCell());
                newEntity.setMedication(entity.getMedication());
                
                newEntity = patientRepo.save(newEntity);
                
                return newEntity;
            }else{
                entity = patientRepo.save(entity);
            }
            return entity;
        }   
    
    }
    
    public void deletePatientByID(String id)throws RecordNotFoundException{
        Optional<Patient> patient = patientRepo.findById(id);
        if(patient.isPresent()){
            patientRepo.deleteById(id);
        }else{
            throw new RecordNotFoundException("No patient record exist for given id");
        }
    }
    
}
