package com.michelin.ns4kafka.models;

import com.michelin.ns4kafka.validation.ConnectValidator;
import com.michelin.ns4kafka.validation.TopicValidator;
import lombok.*;
import org.apache.kafka.common.acl.AclBinding;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Namespace {
    private String name;
    private String cluster;
    // This user is 100% synchonized with the namespace ACLs
    private String defaulKafkatUser;
    // TODO others users within namespace defined and must be "managed" (ACL must be defined and maintained) MVP35
    //private List<User> users;
    private int diskQuota;
    private TopicValidator topicValidator;
    private ConnectValidator connectValidator;




}
