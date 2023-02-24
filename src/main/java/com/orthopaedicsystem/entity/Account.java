package com.orthopaedicsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    Integer id;
    String realname;
    String uname;
    String pwd;
    String phonenumer;
    String utype;
    String updatetime;
    String createtime;
}
