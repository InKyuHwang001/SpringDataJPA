package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;
import study.datajpa.dto.MemberDTO;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    @Query("select m.username from Member m")
    List<String> findUsername();

    @Query("select new study.datajpa.dto.MemberDTO(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDTO> findMemberDto(); //쿼리디에스엘로 더 쉬워짐

    @Query("select m from member where m.username = :name")
    Member findMember(@Param("name") String username);
    //이름기반과 위치기반이 있으나 위기기반은 순서 실수고 바꿀수 있기에

    //컬렉션파라미터 바인딩
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    //반환타입
    //JPA는 유연한 반환타입을 지원한다.
    List<Member> findListByUsername(String username);
    Member findSingleByUsername(String username);
    Optional<Member> findOptionalByUsername(String username);

    //페이징
    Page<Member> findPageByUsername(String name, Pageable pageable); //Count 쿼리 사용
    Slice<Member> findSliceByUsername(String name, Pageable pageable); //Count 쿼리 사용 안함
    List<Member> findListByUsername(String name, Pageable pageable); //Count 쿼리 사용 안함
    List<Member> findAllByUsername(String name, Pageable pageable); //


    Page<Member> findByAge(int age, Pageable pageable);

}
