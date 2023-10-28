package com.TheDonateCompass.TheDonateCompass.modells;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ONG")
public class ONG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Activity")
    private String activity;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;
}
