package org.gadconsulting.homeschedules.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String startDate;
    private String endDate;
    private String status;
    @OneToOne
    @JoinColumn(name = "principal_user_id")
    private User principalUser;
    @ManyToMany
    @JoinTable(name = "additional_users", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> additionalUsers = new HashSet<>();

}
