package com.michelin.ns4kafka.models;

import lombok.*;

import java.util.Collection;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoleBinding {
    private final String apiVersion = "v1";
    private final String kind = "AccessControlEntry";
    // No validation here since name and labels are set server-side
    //TODO RoleBindingSpec + ObjectMeta
    private String namespace;
    private Role role; //TODO Collection<Role>
    private Subject subject; //TODO Collection<Subject>

    public RoleBinding(String namespace, String group){
        this.namespace=namespace;
        this.role = new Role();
        this.subject = new Subject(group);
    }


    //TODO RoleRef instead: roleAdmin, roleRead, roleXXX + RoleRepository
    @Builder
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Role {
        private final Collection<String> resourceTypes = List.of("topics","connects","schemas","consumer-groups", "acls");
        private final Collection<String> verbs = List.of("GET","POST","PUT","DELETE");
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Subject {
        private final SubjectType subjectType = SubjectType.GROUP;
        private String subjectName;

    }

    public enum SubjectType {
        GROUP,
        USER
    }
}
