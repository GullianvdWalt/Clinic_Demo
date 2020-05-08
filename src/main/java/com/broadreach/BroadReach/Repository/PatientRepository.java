/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.broadreach.BroadReach.Repository;


import com.broadreach.BroadReach.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//Repository for Patient class. This reduces the code to implement data access layers
@Repository
public interface PatientRepository extends CrudRepository<Patient, String>{
    
}
