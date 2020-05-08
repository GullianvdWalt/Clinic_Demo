/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.broadreach.BroadReach.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "patient")
public class Patient {
       @Id
       @Column(name="id")
       private String id;
       
       @Column(name="Patient_Name")
       private String patientName;
       
       @Column(name="Patient_Surname")
       private String patientSurname;
       
       @Column(name="DOB")
       private String DOB;
       
       @Column(name="Gender")
       private String gender;
       
       @Column(name="Address")
       private String address;
       
       @Column(name="Cell")
       private String cell;
       
       @Column(name="Emergency_Contact_Name")
       private String emrgContact;
       
       @Column(name="Emergency_Contact_Cell")
       private String emrgContactCell;
       
       @Column(name="Medication")
       private String medication;
       
       
    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmrgContact() {
        return emrgContact;
    }

    public void setEmrgContact(String emrgContact) {
        this.emrgContact = emrgContact;
    }

    public String getEmrgContactCell() {
        return emrgContactCell;
    }

    public void setEmrgContactCell(String emrgContactCell) {
        this.emrgContactCell = emrgContactCell;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }
    

    @Override
    public String toString() {
        return "Patient [Patient_ID=" + id + ", Patient_Name=" + patientName + 
                ", Patient_Surname=" + patientSurname + ", DOB=" + DOB + ", Gender=" 
                + gender + ", Address=" + address + ",Cell=" 
                + cell + ", EmergencyContactName=" + emrgContact 
                + ", EmergencyContactCell=" + emrgContactCell + ", Medication=" + medication + "]";
    }
    
       
}
