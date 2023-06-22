package study.datajpa.dto;

import lombok.Data;
import study.datajpa.entity.Member;

@Data
public class MemberDTO {
    private Long id;
    private String username;
    private String name;

    public MemberDTO() {
    }


    public MemberDTO(Member m) {
        id = m.getId();
        username = m.getUsername();
    }

    public MemberDTO(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }
}
