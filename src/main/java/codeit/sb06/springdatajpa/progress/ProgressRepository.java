package codeit.sb06.springdatajpa.progress;

import codeit.sb06.springdatajpa.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByMember(Member member);
}
