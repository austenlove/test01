package org.zerock.test01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long tno;
    private String name;
    private String id;
    private String pw;
    private int age;
    private String gender;
    private String hobby;
    private String travel;
    private String content;

}
