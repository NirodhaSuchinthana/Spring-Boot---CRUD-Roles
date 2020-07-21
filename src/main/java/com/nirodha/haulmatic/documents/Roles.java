package com.nirodha.haulmatic.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
public class Roles {

    public enum RoleType {
        DRIVER,
        ASSISTANT
    }

    @Id
    private static Integer id;
    private String organization;
    private String firstName;
    private String lastName;
    private String nicNo;
    private RoleType roleType;
    private Date createdDate;
    private Date modifiedDate;

    public Roles(Integer id, String organization, String firstName, String lastName, String nicNo, RoleType roleType) {
        this.id = id;
        this.organization = organization;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nicNo = nicNo;
        this.roleType = roleType;
        this.createdDate = new Date();
        this.modifiedDate = null;
    }
}
