package study.datajpa.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private int id;
    private String username;
    private String name;

    public MemberDTO(int id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }
}
