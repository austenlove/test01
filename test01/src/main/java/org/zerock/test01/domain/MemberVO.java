package org.zerock.test01.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

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
