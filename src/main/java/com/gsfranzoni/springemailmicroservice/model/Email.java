package com.gsfranzoni.springemailmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email {
    @Id()
    private String uuid;
    private String sender;
    private String receiver;
    private String subject;
    private String content;
}
