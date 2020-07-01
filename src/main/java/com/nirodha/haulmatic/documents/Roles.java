package com.nirodha.haulmatic.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Roles {

    public enum RoleType {
        DRIVER,
        ASSISTANT
    }

    @Id
    private Integer id;
    private String organization;
    private String firstName;
    private String lastName;
    private String nicNo;
    private RoleType roleType;

    public Roles(Integer id, String organization, String firstName, String lastName, String nicNo, RoleType roleType) {
        this.id = id;
        this.organization = organization;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nicNo = nicNo;
        this.roleType = roleType;
    }

    public Integer getId() {
        return id;
    }

    public String getOrganization() {
        return organization;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNicNo() {
        return nicNo;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

}
